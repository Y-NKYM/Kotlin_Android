package me.nkym.myfirstapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun RecipeApp(navController: NavController){
    //取得したCategory一覧をMainViewModelクラスから取得するメソッド「.categoriesState」を変数で保持する。
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState
}
