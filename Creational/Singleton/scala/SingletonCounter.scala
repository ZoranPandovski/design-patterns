object SingletonCounter {

  private var currentCounterValue: Int = 0

  def add: Unit = {
    currentCounterValue = currentCounterValue + 1
  }

  def substract: Unit = {
    currentCounterValue = currentCounterValue - 1
  }

  def getCurrentCounterValue: Int = {
    currentCounterValue
  }
}

object Main extends App {
  println("Hello, world!")
  println(SingletonCounter.getCurrentCounterValue)
  SingletonCounter.add
  SingletonCounter.add
  println(SingletonCounter.getCurrentCounterValue)
  SingletonCounter.substract
  println(SingletonCounter.getCurrentCounterValue)
}