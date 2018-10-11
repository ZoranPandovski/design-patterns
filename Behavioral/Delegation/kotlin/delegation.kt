interface ISoundBehaviour {
    fun makeSound()
}

class CatSound : ISoundBehaviour{
    override fun makeSound() {
        println("Meow")
    }
}

class CatRelaxSound : ISoundBehaviour{
    override fun makeSound() {
        println("Prrrrrr")
    }
}


class Cat {
    var sound : ISoundBehaviour = CatSound()

    fun makeSound(){
        this.sound.makeSound()
    }

    fun setSoundBehaviour(newSound : ISoundBehaviour){
        this.sound = newSound
    }
}

fun main(args: Array<String>) {
    val cat : Cat = Cat()
    cat.makeSound() // Meow
    val newSound : ISoundBehaviour = CatRelaxSound()
    cat.setSoundBehaviour(newSound)
    cat.makeSound() // Prrrr
}