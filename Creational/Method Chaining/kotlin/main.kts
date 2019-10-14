class PersonBuilder {
    lateinit var firstName: String
    lateinit var lastName: String

    fun setFirstName(firstName: String) = apply {
        firstName = firstName
    }

    fun setLastName(lastName: String) = apply {
        lastName = lastName
    }

    fun build() = Person(firstName, lastName)
}

data class Person(val firstName: String, val lastName: String)

val person = PersonBuilder()
        .setFirstName("John")
        .setLastName("Doe")
        .build()