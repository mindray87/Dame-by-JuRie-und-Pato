package de.HTWG.se.Dame.aview

import de.HTWG.se.Dame.controller.controllerComponent.Controller


class Tui(controller : Controller){

  def processInputLine(input : String): Unit ={
    input match{
      case "choose" => println(controller.showGrid())
      case "show" => println(controller.showGrid())
      case "ínfo" => println(controller.getMessage())
      case "q" => println("Goodbye")
      case _ => input.toList.filter(c => c != ' ').map(c => c.toString.toInt)
      match {
        case row :: col :: Nil => println(controller.getPossibleMoves(row, col))
        case _ =>
      }
    }
  }


}