
/**
 * Lazy initialization Singleton Pattern
 *
 * Thread safety with SYNCHRONIZED mode to ensure only one instance
 * will be created in race condition.
 */
fun main(args: Array<String>) {
    DummySingleton.instance.print()
}

class Dummy {
    fun print() = println("Print Something!")
}

object DummySingleton {
    val instance: Dummy by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        Dummy()
    }
}
