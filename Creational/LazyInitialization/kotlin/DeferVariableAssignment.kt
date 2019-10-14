/**
 * Lateinit allows us to tell the compiler that this variable will be asigned later, if we try to access an
 * unitialized variable we get an UninitializedPropertyAccessException exception thrown.
 * */
fun main(args: Array<String>) {
    val deferredClass = Deferred()

    try {
        deferredClass.printDeferred()
    } catch (e: UninitializedPropertyAccessException) {
        println("Exception thrown!")
    }

    deferredClass.deferred = "This variable is now initialized so we can access it"
    deferredClass.printDeferred()
}

class Deferred(){
    lateinit var deferred: String

    fun printDeferred() { println("deferred = ${deferred}") }
}