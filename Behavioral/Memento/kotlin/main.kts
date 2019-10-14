/**
 * The Originator is the class that creates the memento. This class is also responsible for restoring the state from a given memento.
 */

class Originator {
    class Memento<T>(val state: T) {
        init {
            println("Creating memento with state $state")
        }
    }

    var state = ""
        private set(v) {
            println("Originator setting state to $v")
            field = v
        }

    fun update(newState: String) {
        state = newState
    }

    fun restore(memento: Memento<String>) {
        println("Restoring state to ${memento.state}")
        state = memento.state
    }

    fun save() = Memento(state)
}


val states = mutableListOf<Originator.Memento<String>>()

val originator = Originator()

originator.update("State 1")
originator.update("State 2")
states.add(originator.save())

originator.update("State 3")
states.add(originator.save())

originator.update("State 4")

originator.restore(states[1])