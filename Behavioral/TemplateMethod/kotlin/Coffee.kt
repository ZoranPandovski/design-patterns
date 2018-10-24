class Coffee : CaffeineBeverage() {
    override fun brew() {
        println("Brew the coffee grinds")
    }

    override fun addCondiments() {
        println("Add sugar and milk")
    }
}