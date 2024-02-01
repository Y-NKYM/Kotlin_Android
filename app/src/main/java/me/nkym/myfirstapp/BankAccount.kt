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
        balance += amount
        transactionHistory.add("$accountHolder deposited $$amount")
    }

    //出金
    fun withdraw(amount: Double){
        if(amount <= balance){
            balance -= amount
            transactionHistory.add("$accountHolder withdrew $$amount")
        } else {
            println("You don't have the funds to withdraw $$amount")
        }
    }

    //履歴
    fun displayTransactionHistory(){
        println("Transaction history for $accountHolder")
        for(transaction in transactionHistory){
            println(transaction)
        }
    }

    fun displayBalance(){
        println("$accountHolder's balance is $$balance")
    }
}