package me.nkym.myfirstapp

fun main(){
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
}