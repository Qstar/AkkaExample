package Example_01

//https://juejin.im/post/59e75f196fb9a0450b657bed
//Akka系列

import akka.actor._
import akka.event.Logging

trait Action {
  val message: String
  val time: Int
}

case class TurnOnLight(time: Int) extends Action { // 开灯消息
  val message = "Turn on the living room light"
}

case class BoilWater(time: Int) extends Action { // 烧水消息
  val message = "Burn a pot of water"
}

class RobotActor extends Actor {
  val log = Logging(context.system, this)

  def receive: Receive = { //机器人接受指令
    case t: TurnOnLight => log.info(s"${t.message} after ${t.time} hour")
    case b: BoilWater => log.info(s"${b.message} after ${b.time} hour")
    case _ => log.info("I can not handle this message")
  }
}


// 利用Actor来实现一个模拟机器人
object Example_01 extends App {
  val actorSystem = ActorSystem("robot-system") //
  println(s"the ActorSystem logLevel is ${actorSystem.settings.LogLevel}")
  val robotActor = actorSystem.actorOf(Props(new RobotActor()), "robotActor") //创建一个机器人
  robotActor ! TurnOnLight(1) //给机器人发送一个开灯命令
  robotActor ! BoilWater(2) //给机器人发送一个烧水命令
  robotActor ! "who are you" //给机器人发送一个任意命令
  actorSystem stop robotActor
  actorSystem shutdown() //立即结束
}