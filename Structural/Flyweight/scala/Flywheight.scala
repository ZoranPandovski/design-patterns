import scala.collection.mutable.ListBuffer

case class Flyweight(sharedState: String)

case class Context(uniqueState: Int, flyweight: Flyweight)

class FlyweightFactory {

  var flyweights = ListBuffer.empty[Flyweight]

  def getFlyweight(sharedState: String): Flyweight = {
    val selectedFlyweights = flyweights.filter(flyweight => flyweight.sharedState.equals(sharedState))

    if (selectedFlyweights.size > 0) {
      selectedFlyweights(0)
    } else {
      val newFlyweight = Flyweight(sharedState)
      flyweights.addOne(newFlyweight)
      newFlyweight
    }
  }

  def total = flyweights.size
}


class Client(flyweightFactory: FlyweightFactory) {

  val contexts = ListBuffer.empty[Context]

  def getContext(uniqueState: Int, sharedState: String): Context = {
    val flyweight = flyweightFactory.getFlyweight(sharedState)
    val context = Context(uniqueState, flyweight)
    contexts.addOne(context)

    context
  }

}

object FlyweightPattern {

  def main(args: Array[String]): Unit = {
    val flyweightFactory = new FlyweightFactory()
    val client = new Client(flyweightFactory)


    val uniqueStates = Range(0, 10).toSeq
    val sharedStates = Seq("Alpha", "Beta", "Gamma")

    val contexts = uniqueStates.flatMap(uniqueState => {
      sharedStates.map(sharedState => client.getContext(uniqueState, sharedState))
    })

    println(f"Contexts: ${contexts.size}")
    println(f"Flyweights: ${flyweightFactory.total}")
  }
}
