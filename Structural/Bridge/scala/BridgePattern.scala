trait Implementation {

    def operationA(): Unit

    def operationB(num: Int): Unit
}

class Abstraction(val implementation: Implementation) {

    def operationOne() = {
        this.implementation.operationA()
        this.implementation.operationB(1)
    }

    def operationTwo() = {
        this.implementation.operationA()
    }
}

class ConcreteImplementationAlpha extends Implementation {

    override def operationA() = println("Concrete Alpha operation A")

    override def operationB(num: Int) = println(s"Concrete Alpha operation B: $num")
}

class ConcreteImplementationBeta extends Implementation {

    override def operationA() = println("Concrete Beta operation A")

    override def operationB(num: Int) = println(s"Concrete Beta operation B: $num")
}

class ExtendedAbstraction(override val implementation: Implementation) extends Abstraction(implementation) {

    def operationThree(): Unit = this.implementation.operationB(3)
}

object BridgePattern extends App {

    val abstractionWithConcreteImplAlpha = new Abstraction(new ConcreteImplementationAlpha)
    val abstractionWithConcreteImplBeta = new Abstraction(new ConcreteImplementationBeta)
    val extendedAbstractionWithConcreteImplAlpha = new ExtendedAbstraction(new ConcreteImplementationAlpha)

    abstractionWithConcreteImplAlpha.operationOne()
    abstractionWithConcreteImplBeta.operationTwo()
    extendedAbstractionWithConcreteImplAlpha.operationThree()
}

