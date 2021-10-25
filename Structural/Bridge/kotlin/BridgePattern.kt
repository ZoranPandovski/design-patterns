interface Color {
    fun getColor()
}

class Yellow: Color {
    override fun getColor() {
        println("Yellow")
    }
}

class Red: Color {
    override fun getColor() {
        println("Red")
    }
}

interface House {
    val color: Color
    fun show()
}

class WoodHouse(override val color: Color): House {
    override fun show() {
        print("The wood house color is ")
        color.getColor()
    }
}

class RockHouse(override val color: Color): House {
    override fun show() {
        print("The rock house color is ")
        color.getColor()
    }
}

fun main() {
    val yellowWoodHouse = WoodHouse(color = Yellow())
    yellowWoodHouse.show()
    val yellowRockHouse = RockHouse(color = Yellow())
    yellowRockHouse.show()
    val redWoodHouse = WoodHouse(color = Red())
    redWoodHouse.show()
    val redRockHouse = RockHouse(color = Red())
    redRockHouse.show()
}