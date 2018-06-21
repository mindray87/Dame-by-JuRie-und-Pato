package de.HTWG.se.Dame.aview

import de.HTWG.se.Dame.controller.controllerComponent.Controller


class Tui(controller : Controller){

  def processInputLine(input : String): Unit ={
    input match{
      case "s" => println(controller.showGrid())
      case "q" => println("Goodbye")
    }
  }


}