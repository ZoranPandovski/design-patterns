interface King {
    fun getDescription(): String
}

interface Army {
    fun getDescription(): String
}

interface KindomFactory {
    fun createKing(): King
    fun createArmy(): Army
}

class NorthKing : King {
    override fun getDescription() = "King Stark"
}

class RockKing : King {
    override fun getDescription() = "King Lannister"
}

class NorthArmy : Army {
    override fun getDescription() = "North army"
}

class RockArmy : Army {
    override fun getDescription() = "Rock army"
}

class NorthFactory : KindomFactory {
    override fun createKing() = NorthKing()
    override fun createArmy() = NorthArmy()
}

class RockFactory : KindomFactory {
    override fun createKing() = RockKing()
    override fun createArmy() = RockArmy()
}

fun main(args: Array<String>) {
    val factory = if (args.isEmpty())
        NorthFactory()
    else
        RockFactory()

    val king = factory.createKing()
    val army = factory.createArmy()

    println("King: ${king.getDescription()}")
    println("Army: ${army.getDescription()}")
}
