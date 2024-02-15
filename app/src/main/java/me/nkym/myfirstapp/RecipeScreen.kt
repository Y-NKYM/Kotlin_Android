package me.nkym.myfirstapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier
){
    /*
    MainViewModelインスタンスオブジェクト化し、関数を使用するために変数に代入する。
    viewModel型（データ変更時に随時変更してくれるための型）を読み込む。
    式：val 変数名: オブジェクト型 = viewModel()
    */
    val recipeViewModel: MainViewModel = viewModel()

    /*
    getValueをインポートし、取得状況によってのRecipeStateを取得。
    上記インスタンス生成時、インターネットを通じてデータの取得が行われる。
    その取得状況をまとめたオブジェクトクラスを取得する。
    */
    val viewState by recipeViewModel.categoriesState

    /*
    取得したデータの内容によって画面内に反映させるものが変化する。
    読み込み中の場合、読み込みエラーの場合、その他（読み込み成功）それぞれの記述。
    */
    Box(modifier = Modifier.fillMaxSize()){
        when{
            viewState.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }
            viewState.error != null -> {
                Text(text = "ERROR OCCURRED")
            }
            else -> {
                //Display Categories
                CategoryScreen(categories = viewState.list)
            }
        }
    }
}

//要素全体でのレイアウト
@Composable
fun CategoryScreen(categories: List<Category>){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
        ){
        items(categories){
            category ->
            CategoryItem(category = category)
        }
    }
}

//個々の要素のレイアウト
@Composable
fun CategoryItem(category: Category){
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        //Image
        Image(
            //Loads the image by giving the ImageURL to the method.
            painter = rememberAsyncImagePainter(model = category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier.fillMaxSize().aspectRatio(1f)
        )


        //Text
        Text(
            text = category.strCategory,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
