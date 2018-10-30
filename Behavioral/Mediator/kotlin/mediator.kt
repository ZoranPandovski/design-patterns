class Mediator(val users: MutableList<User> = ArrayList()) {
    fun sendMessage(message: String, sender: User) {
        users.filter {
            it !== sender
        }.forEach {
            it.receive(message)
        }
    }
}


class User(val name: String, val mediator: Mediator) {

    init {
        mediator.users.add(this)
    }

    fun receive(msg: String) {
        println("$name has been received: $msg")
    }

    fun send(msg: String) {
        mediator.sendMessage(msg, this)
    }
}

fun main(args: Array<String>) {
    val mediator = Mediator()
    User("John Doe", mediator)
    User("Doe John", mediator)
    User("Dohn Joe", mediator)
    User("User1", mediator).send("Hi everyOne")
}