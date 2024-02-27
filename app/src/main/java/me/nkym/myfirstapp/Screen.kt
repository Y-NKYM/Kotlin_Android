package me.nkym.myfirstapp

/*
sealed classとは
確認が実行前のコンパイル時に制限の確認が行われるため、
sealedクラスを継承したサブクラスが全て明らかになり、
そのルート以外への対応ソースコードの記述ができる。
*/
sealed class Screen(val route:String) {
    /*
    object keyword:
    一つしか生成されないことが保証されたクラスを生成。
    アプリケーション全体で単一のインスタンスを共有する場合に使用。
    */
    object RecipeScreen:Screen("recipeScreen")
}