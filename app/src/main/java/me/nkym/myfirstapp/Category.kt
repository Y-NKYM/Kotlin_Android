package me.nkym.myfirstapp

//"https://www.themealdb.com/api/json/v1/1/categories.php"使用。
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)

//JSON database内は"categories"という名のリスト内にオブジェクトが格納されているため、同じ名前を使用する。。
data class CategoriesResponse(
    val categories: List<Category>
)