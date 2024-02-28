package me.nkym.myfirstapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController){
    //取得したCategory一覧をMainViewModelクラスから取得するメソッド「.categoriesState」を変数で保持する。
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    //
    NavHost(
        navController = navController,
        //Screenファイル内にあるRecipeScreenオブジェクト内のroute変数値を代入する＝"recipeScreen"となる。
        startDestination = Screen.RecipeScreen.route
    ){
        composable(route = Screen.RecipeScreen.route){
            RecipeScreen(
                viewState = viewState,
                navigateToDetail = {

            })
        }
    }
}
