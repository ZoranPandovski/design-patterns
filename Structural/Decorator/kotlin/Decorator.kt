// Head first: design pattern chapter 3

interface Beverage {
    fun getDescription(): String
    fun cost(): Double
}

class Espresso() : Beverage {
    override fun getDescription() = "Espresso"
    override fun cost() = 1.49
}

class Decaf() : Beverage {
    override fun getDescription() = "Decaf"
    override fun cost() = 1.99
}

class HouseBlend() : Beverage {
    override fun getDescription() = "HouseBlend"
    override fun cost() = 2.49
}

class DarkRoast() : Beverage {
    override fun getDescription() = "DarkRoast"
    override fun cost() = 1.49
}

open class BeverageDecorator(val beverage: Beverage) : Beverage {
    override fun cost() = beverage.cost()
    override fun getDescription() = beverage.getDescription()
}

class Milk(beverage: Beverage) : BeverageDecorator(beverage) {
    override fun cost() = super.cost() + 0.49
    override fun getDescription() = "${super.getDescription()}, with milk"
}

class Mocha(beverage: Beverage) : BeverageDecorator(beverage) {
    override fun cost() = super.cost() + 0.69
    override fun getDescription() = "${super.getDescription()}, with mocha"
}

class Soy(beverage: Beverage) : BeverageDecorator(beverage) {
    override fun cost() = super.cost() + 0.98
    override fun getDescription() = "${super.getDescription()}, with soy"
}

fun main(args: Array<String>) {
    val simpleEspresso = Espresso()
    println("${simpleEspresso.getDescription()}: ${simpleEspresso.cost()}")
    var decafSoyMilk: Beverage = Decaf()
    println("${decafSoyMilk.getDescription()}: ${decafSoyMilk.cost()}")
    decafSoyMilk = Milk(decafSoyMilk)
    println("${decafSoyMilk.getDescription()}: ${decafSoyMilk.cost()}")
    decafSoyMilk = Soy(decafSoyMilk)
    println("${decafSoyMilk.getDescription()}: ${decafSoyMilk.cost()}")
}
