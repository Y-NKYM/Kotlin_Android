package me.nkym.myfirstapp

fun main(){
    val frankBankAccount = BankAccount("Frank", 12345.67)
//    println(frankBankAccount.accountHolder)
//    println(frankBankAccount.balance)

    frankBankAccount.deposit(200.0)
    frankBankAccount.withdraw(120.0)
    frankBankAccount.deposit(3000.0)
    frankBankAccount.deposit(123.0)
    frankBankAccount.withdraw(2222.15)
    frankBankAccount.displayTransactionHistory()

    frankBankAccount.displayBalance()
}