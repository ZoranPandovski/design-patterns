interface Component {
    fun println()
}

class Leaf(val nome: String) : Component{
    override fun println() {
        println(nome)
    }
}

class Composite(val nome: String) : Component{
    val components = ArrayList<Component>()
    override fun println() {
        println(nome)
        components.forEach {
            it.println()
        }
    }

    fun addComponent(vararg c: Component){
        c.forEach {
            components.add(it)
        }

    }
}

fun main (args: Array<String>){
    val eyes = Composite("eyes")
    val reye = Leaf("reye")
    val leye = Leaf("leye")
    eyes.addComponent(reye, leye)
    val nose = Leaf("nose")
    val face = Composite("face")
    val mouth = Leaf ("mouth")
    face.addComponent(eyes, nose, mouth)
    face.println()
}