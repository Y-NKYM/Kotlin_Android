package me.nkym.myfirstapp

fun main(){
    /* コンピューター側の手 */
    var computerChoice = ""

    /* プレイヤー側の手 */
    var playerChoice = ""
    println("Rock, Paper, or Scissors? Enter your choice!")

    /* プレイヤーの手を取得 */
    playerChoice = readln()
    if(playerChoice.lowercase().equals("rock")){
        playerChoice = "Rock"
    } else if(playerChoice.lowercase().equals("paper")){
        playerChoice = "Paper"
    } else if(playerChoice.lowercase().equals("scissors")){
        playerChoice = "Scissors"
    } else {
        println("Please select Rock, Paper, or Scissors.")
    }

    /* コンピューター側の手をランダムで決める */
    val randomNumber = (1..3).random()
    if(randomNumber == 1){
        computerChoice = "Rock"
    } else if(randomNumber == 2) {
        computerChoice = "Paper"
    } else if(randomNumber == 3) {
        computerChoice = "Scissors"
    }
    println(computerChoice)

    /* 勝者を発表 */



}