import akka.actor.{Actor, ActorSystem, Props}

//define Actor Messages
case class  WhoToGreet(who: String)

//define Greeter Actor
class Greeter extends Actor {
  def receive = {
    case WhoToGreet(who) => println(s"Hello $who")
  }
}


object HelloAkka extends App {

  //Create the 'hello akka' actor system
  val system = ActorSystem("Hello-Akka")

  //Create the 'greeter' actor
  val greeter = system.actorOf(Props[Greeter], "greeter")

  //Send WhoToGreet Message to actor
  greeter ! WhoToGreet("Akka")
}
