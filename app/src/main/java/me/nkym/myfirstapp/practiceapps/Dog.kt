package me.nkym.myfirstapp.practiceapps

//Basics for "class" object.
class Dog(val name: String, var age: Int = 0) {

    init{
        bark(name)
    }

    fun bark(name: String){
        println("$name says Wolf Wolf")
    }
}