package me.nkym.myfirstapp.inheritance

class ChildClass: BaseClass() {
    override fun role(){
        super.role()
        println("Knight of the House of BaseClass")
    }
}