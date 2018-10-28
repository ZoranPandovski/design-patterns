interface Animal {
    fun accept(animalOperation: AnimalOperation)
}

interface AnimalOperation {
    fun visitMonkey(monkey: Monkey);
    fun visitLion(lion: Lion);
}

class Lion : Animal {
    fun roar() {
        println("Roaaar!")
    }
    
    override fun accept(animalOperation: AnimalOperation) {
        animalOperation.visitLion(this)
    }
}

class Monkey : Animal {
    fun shout() {
        println("Ooh oo aa aa!")
    }
    
    override fun accept(animalOperation: AnimalOperation) {
        animalOperation.visitMonkey(this)
    }
}

class SpeakOperation : AnimalOperation {
    override fun visitMonkey(monkey: Monkey) {
        monkey.shout()
    }
    
    override fun visitLion(lion: Lion) {
        lion.roar()
    }
}

fun main(args: Array<String>) {
	val speakOperation = SpeakOperation()
    val monkey = Monkey()
    monkey.accept(speakOperation)
}