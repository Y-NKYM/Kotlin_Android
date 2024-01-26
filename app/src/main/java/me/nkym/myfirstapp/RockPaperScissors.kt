package me.nkym.myfirstapp

fun main(){
    /* コンピューター側の手 */
    var computerChoice = ""

    /* プレイヤー側の手 */
    var playerChoice = ""
    println("Rock, Paper, or Scissors? Enter your choice!")

    /* プレイヤーの手を取得 */
    while(true) {
        playerChoice = readln()
        if (playerChoice.lowercase().equals("rock")) {
            playerChoice = "Rock"
            break
        } else if (playerChoice.lowercase().equals("paper")) {
            playerChoice = "Paper"
            break
        } else if (playerChoice.lowercase().equals("scissors")) {
            playerChoice = "Scissors"
            break
        } else {
            println("Please select Rock, Paper, or Scissors.")
        }
    }

    /* コンピューター側の手をランダムで決める */
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
    println(computerChoice)

    /* 勝者を発表 */
    val winner = when {
        playerChoice == computerChoice -> "Tie"
        playerChoice == "Rock" && computerChoice == "Scissors" -> "Player"
        playerChoice == "Paper" && computerChoice == "Rock" -> "Player"
        playerChoice == "Scissors" && computerChoice == "Paper" -> "Player"
        else -> "Computer"
    }

    if(winner == "Tie"){
        println("It's a tie!")
    } else {
        println("$winner won!")
    }

}