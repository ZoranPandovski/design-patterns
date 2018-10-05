sealed class State

class ConcreteStateA() : State()

class ConcreteStateB() : State()

class Context {
    private var state : State = ConcreteStateA()

    fun setStateB() {
        state = ConcreteStateB()
    }

    fun setStateA() {
        state = ConcreteStateA()
    }


    val stateText : String
        get() = when(state) {
            is ConcreteStateA -> "State A"
            is ConcreteStateB -> "State B"
        }

    override fun toString() = "State: $stateText"
}

fun main(args: Array<String>) {
    val context = Context()
    context.setStateA()
    println(context)
    context.setStateB()
    println(context)
}