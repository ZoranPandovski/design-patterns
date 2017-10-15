object Singleton {
	var b: String? = null
}

fun main(args: Array<String>) {
	Singleton.b = "foo" // is initialized at this point
	println(Singleton.b) // prints "foo"
}