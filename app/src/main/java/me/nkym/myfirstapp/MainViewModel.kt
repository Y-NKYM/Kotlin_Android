package me.nkym.myfirstapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    /*
    privateで用意してから外部からの取得用変数を生成する理由として、
    private変数がそのオブジェクト内関数で使用されているため、上書きしてほしくない。
    ただ、データを外部へ渡したいので、もう一つ変数を用意する。
    */
    private val _categoryState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categoryState

    init {
        fetchCategories()
    }

    private fun fetchCategories(){
        //インターネットから情報を取得する際は、取得まで時間がかかるのでsuspendで取得する必要がある。
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