package me.nkym.myfirstapp.practiceapps

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

    /* Function */
    makeCoffee(1, "Jimmy")
    makeCoffee(5, "Henry")

    println("Enter number 1")
    val num1 = readln().toInt()
    println("Enter number 2")
    val num2 = readln().toInt()

    var myResult = divide(num1, num2)
    println(myResult)

    //Creating an object/instance of the class Dog
    var daisy = Dog("Daisy")
    println(daisy.name)
    println(daisy.age)
    daisy.age = 2
    println(daisy.age)



    //List
    val shoppingList = listOf("A", 1, "C")
    val shoppingList2 = mutableListOf("A", 1, "C")
    var shoppingList3 = mutableListOf<String>("A", "B", "C")
    shoppingList3.removeAt(1)
    shoppingList3.add(1, "D")
    shoppingList3[0] = "E"
    shoppingList3.set(0, "F")

    println(shoppingList3)
    var hasElement = shoppingList3.contains("A")
    println(hasElement)

    for(item in shoppingList3) {
        println(item)
        if (item == "D") {
            break
        }
    }

    println(shoppingList3.size)
    println(0 until shoppingList3.size)
    for(index in 0 until shoppingList3.size){
        println("item ${shoppingList3[index]} is at index $index")
    }

    //Lambda
    //val <variableName>: (<parameterDataType>) -> <returnDataType> = { <source code> }
    val double: (Int) -> Int = { it * 2 }
    println(double(10))

    var number = 5
    val freeLambda: (Int) -> Unit
    freeLambda = { number *= it }
    freeLambda(3)
    println(number)

    //Map
    val numbers = listOf(1, 2, 3)
    val doubled = numbers.map { it * 2 }
    println(doubled)

    //Copy
    data class Vase(
        val color: String,
        val design: String
    )
    val blueRoseVase = Vase("Blue", "Rose")
    val redRoseVase = blueRoseVase.copy(color = "Red")

    val mutableArray = mutableListOf(1, 2, 3)
    val myArray = mutableArray.toMutableList()
    myArray[0] = 5
    println(myArray)
    println(mutableArray)

    //Let
    //nullable String
    var name:String? = "Ella"
    name?.let{
        println(it.toUpperCase())
    }
    println(name?.toUpperCase())
    name = null
    println(name?.length)

    //配列内の要素を[＋、－]記号で要素の追加削除が可能。
    var myList = mutableListOf(1, 2, 3, 4, 5)
    println(myList - 2)
    println(myList + 6)
    */

    //Try, Catch and Finally
    try {
        val number = readln().toInt()
        println("User entered $number")
    } catch(e: Exception){
        println(e.message)
    } finally {
        println("Execute done.")
    }
}

/*
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
fun sum(num1: Int, num2: Int):Int{
    val result = num1 + num2
    return result
}
fun divide(num1: Int, num2: Int):Double{
    val result = num1/num2.toDouble()
    return result
}

/* Data Class */
data class CoffeeDetails(
    val sugarCount: Int,
    val name: String,
    val size: String,
    val creamAmount: Int
)
fun createCoffee(coffeeDetails: CoffeeDetails){
    if(coffeeDetails.sugarCount == 1){
        println("Coffee with ${coffeeDetails.sugarCount} spoon of sugar for ${coffeeDetails.name}")
    } else if(coffeeDetails.sugarCount == 0) {
        println("Coffee with no sugar for ${coffeeDetails.name}")
    } else {
        println("Coffee with ${coffeeDetails.sugarCount} spoons of sugar for ${coffeeDetails.name}")
    }
}
*/