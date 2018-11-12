import java.util.*
import java.util.Random

class Printer : Observer{
    override fun update(p0: Observable?, p1: Any?) {
        val value = p1 as Int
        println(value)
    }

}

class RandomGenerator : Observable() {

    fun newRandom(){
        setChanged()
        notifyObservers(Random().nextInt())
    }
}

fun main (args : Array<String>){
    val p = Printer()
    val r = RandomGenerator()

    r.addObserver(p)
    r.newRandom()
    r.newRandom()
    r.newRandom()


}