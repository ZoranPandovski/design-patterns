
class Tea : CaffeineBeverage() {
    override fun brew() {
        println("Steep the teabag in the water")
    }

    override fun addCondiments() {
        println("Add lemon")
    }
}
