// define the singleton
object Singleton {
  var property: String = _
}

// use this singleton
object Main extends App {
  Console.println("Hello World: " + Singleton.property)
  Singleton.property = "THE BIG STRING"
  Console.println("Hello World: " + Singleton.property)
}
