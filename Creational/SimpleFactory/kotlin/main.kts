interface Pizza {
    fun prepare()
    fun bake()
    fun cut()
    fun box()
}

class CheesePizza : Pizza {
    override fun prepare() = println("Preparing cheese pizza")
    override fun bake() = println("Baking cheese pizza")
    override fun cut() = println("Cutting cheese pizza")
    override fun box() = println("Packaging cheese pizza")
}

class PepperoniPizza : Pizza {
    override fun prepare() = println("Preparing pepperoni pizza")
    override fun bake() = println("Baking pepperoni pizza")
    override fun cut() = println("Cutting pepperoni pizza")
    override fun box() = println("Packaging pepperoni pizza")
}

enum class PizzaType { Cheese, Pepperoni }

object PizzaStore {
    fun orderPizza(type: PizzaType) = when (type) {
        PizzaType.Cheese -> CheesePizza()
        PizzaType.Pepperoni -> PepperoniPizza()
    }
}

val myPizza = PizzaStore.orderPizza(PizzaType.Cheese)

myPizza.prepare()
myPizza.bake()
myPizza.cut()
myPizza.box()