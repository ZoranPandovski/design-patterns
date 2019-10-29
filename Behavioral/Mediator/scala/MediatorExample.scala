case class User(name: String, messenger: Messenger) {

  // Every instance of User will send their own name to the created mediator class(Messenger)
  // Messenger sendMessage implementation is unknown to User class
  def sendMessage(msg: String): Unit = {
    messenger.sendMessage(name, msg)
  }
}

// Messenger here acts as the Mediator for User class (sendMessage)
// Single instance of messenger can be used by multiple users
class Messenger {
  def sendMessage(name: String, message: String): Unit = {
    println(s"$name: $message")
  }
}

object MediatorExample extends App {
  // Create a messenger instance
  val messenger = new Messenger

  // Users using the same instance of messenger
  val tom = User("Tom", messenger)
  val mark = User("Mark", messenger)

  println("Happy chatting!\n")

  // Send messages using our users
  tom.sendMessage("How are you doing?")
  mark.sendMessage("I am good! How about you?")
}
