abstract class CaffeineBeverage {
    fun prepareRecipe() {
        boilWater()
        brew()
        pourInCup()
        addCondiments()
    }

    abstract fun brew()

    abstract fun addCondiments()

    fun boilWater() {
        println("Boil some water")
    }

    fun pourInCup() {
        println("Pour beverage in a cup")
    }
}
