package me.nkym.myfirstapp.inheritance

open class ChildClass2: BaseClass(), Archery, Singer {

    override fun role(){
        println("Bard of the House of BaseClass")
    }

    override fun archery() {
        super.archery()
        println("Archery skills enhanced by BaseClass")
    }

    override fun sing() {
        super.sing()
        println("Singing skills enhanced by BaseClass")
    }
}