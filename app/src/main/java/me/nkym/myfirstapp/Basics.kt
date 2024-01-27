package me.nkym.myfirstapp

import androidx.core.text.isDigitsOnly

fun main(){
    /*

    /* Variables */
    val number1 = 1
    var myAge = 20
    myAge = 21
    println(myAge)

    /* Datatype */
    val num1 = 1  //Datatype: Int
    val num2: Byte = 1  //Datatype: Byte

    /* Float and Double */
    val pi = 3.14
    val pi2 = 3.14f
    val pi3 = 3.1415926535f
    println(pi3)  //3.1415927

    /* Unsigned Integer Type */
    //Decimals are only available on float and double.
    //Needs "u" at the end of the value.
    var age: UShort = 20u

    /* Boolean */
    val myTrue = true
    val myFalse = false
    var boolean: Boolean? = null
    println(boolean)
    boolean = true
    println(boolean)

    /* Operator */
    println(myTrue || myFalse)  //true
    println(myTrue && myFalse)  //false
    println(!myTrue)   //false
    println(!boolean)  //false
    println(myTrue && boolean)  //true

    /* Character */
    val Char1 = 'a'
    val myChar = '\u00AE'

    /* String */
    var myName: String = "Hello World"
    var name = ""  //not null
    name = "Name"
    println(name)
    println(name.lowercase())
    println(name.uppercase())
    println(name + "is Alice")

    /* If Statement */
    var n = 18
    if(n >= 18){
        println("You can go into the club")
    } else {
        println("You are too young to go into the club")
    }

    /* Converting datatype */
    var enteredAge = readln()
    println(enteredAge.toIntOrNull())
    val convertedAge = enteredAge.toIntOrNull()
    if(convertedAge == null){
        println("Please enter a number")
    } else if(convertedAge >= 18) {
        println("You can go into the club")
    } else {
        println("You are too young to go into the club")
    }

    /* When statement */
    var computerChoice = ""
    val randomNumber = (1..3).random()
    when (randomNumber) {
        1 -> {
            computerChoice = "Rock"
        }
        2 -> {
            computerChoice = "Paper"
        }
        3 -> {
            computerChoice = "Scissors"
        }
    }

    /* While statement */
    var count = 0
    while(count < 3){
        println("Count is $count")
        count++
    }
    println("Loop is done")

    */

    /* Function */
    fun makeCoffee(sugarCount: Int, name: String){
        if(sugarCount == 1){
            println("Coffee with $sugarCount spoon of sugar for $name")
        } else if(sugarCount == 0) {
            println("Coffee with no sugar for $name")
        } else {
            println("Coffee with $sugarCount spoons of sugar for $name")
        }

    }
    makeCoffee(1, "Jimmy")
    makeCoffee(5, "Henry")

}