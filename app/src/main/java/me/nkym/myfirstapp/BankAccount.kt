package me.nkym.myfirstapp

class BankAccount(
    //所有者
    var accountHolder: String,
    //金
    var balance: Double
) {
    //履歴表示用配列
    private val transactionHistory = mutableListOf<String>()

    //入金
    fun deposit(amount: Double){

    }

    //出金
    fun withdraw(amount: Double){

    }

    //履歴
    fun displayTransactionHistory(){

    }
}