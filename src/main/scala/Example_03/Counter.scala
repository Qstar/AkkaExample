package Example_03

import akka.actor._
import akka.event.LoggingReceive

object Counter {

  case class UseStorage(storage: Option[ActorRef])

}

class Counter(key: String, initialValue: Long) extends Actor {

  import Counter._
  import CounterService._
  import Storage._

  var count: Long = initialValue
  var storage: Option[ActorRef] = None

  def receive = LoggingReceive {
    case UseStorage(s) =>
      storage = s
      storeCount()

    case Increment(n) =>
      count += n
      storeCount()

    case GetCurrentCount =>
      sender() ! CurrentCount(key, count)

  }

  def storeCount() {
    // Delegate dangerous work, to protect our valuable state.
    // We can continue without storage.
    storage foreach {
      _ ! Store(Entry(key, count))
    }
  }

}