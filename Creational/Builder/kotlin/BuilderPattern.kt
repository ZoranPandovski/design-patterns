fun main(args: Array<String>) {
    val john = PersonBuilder {
        name = "John Smith"
        age = 20
        interests = arrayListOf("Football")
    }
    println(john.age)
}

data class Person(
        val name: String,
        val age: Int,
        val interests: ArrayList<String>
)

class PersonBuilder() {

    constructor(init: PersonBuilder.() -> Unit) : this() {
        init()
    }

    var name: String = ""
    var age: Int = 0
    var interests: ArrayList<String> = ArrayList()

    fun name(value: PersonBuilder.() -> String) = apply { name = value() }

    fun age(value: PersonBuilder.() -> Int) = apply { age = value() }

    fun interests(value: PersonBuilder.() -> ArrayList<String>) = apply { interests = value() }

    fun build() = Person(name, age, interests)

}
