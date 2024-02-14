package me.nkym.myfirstapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _categoryState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categoryState

    init {
        fetchCategories()
    }

    private fun fetchCategories(){
        viewModelScope.launch {
            try {
                //ApiService内に存在するgetCategories()を実行し、Category内に存在するCategoriesResponseデータクラス化されたデータを取得。
                val response = recipeSerivce.getCategories()
                _categoryState.value = _categoryState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            } catch(e: Exception){
                _categoryState.value = _categoryState.value.copy(
                    loading = false,
                    error = "Error fetching categories. Message: ${e.message}"
                )
            }
        }
    }

    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )
}