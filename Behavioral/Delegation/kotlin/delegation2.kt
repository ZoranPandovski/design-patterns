interface SoundBehaviour {
    fun makeSound()

    class SoundMaker(private val sound: String) : SoundBehaviour {
        override fun makeSound() {
            println(sound)
        }
    }
}

class CatSound private constructor(sound: SoundBehaviour) : SoundBehaviour by sound {
    companion object {
        fun create() = CatSound(SoundBehaviour.SoundMaker("meow"))
    }
}

class CatRelaxSound private constructor(sound: SoundBehaviour) : SoundBehaviour by sound {
    companion object {
        fun create() = CatRelaxSound(SoundBehaviour.SoundMaker("purrrrrrrr"))
    }
}

class Cat {
    var sound: SoundBehaviour = CatSound.create()
    fun makeSound() = sound.makeSound()
}

fun main(args: Array<String>) {
    val cat: Cat = Cat()

    // Output: meow
    cat.makeSound()

    cat.sound = CatRelaxSound.create()

    // Output: purrrrrrrr
    cat.makeSound()
}