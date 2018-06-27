package de.HTWG.se.Dame

import scala.io.StdIn.readLine
import de.HTWG.se.Dame.aview.Tui
import de.HTWG.se.Dame.controller.controllerComponent.Controller
import de.HTWG.se.Dame.model.enums.Color
import de.HTWG.se.Dame.model.{Grid, Player}

object Doughts {

  def main(args: Array[String]): Unit = {

    var input: String = ""
    val gridSize = 10
    val grid = new Grid(gridSize)

    val controll = new Controller("Julian", "Patrick", gridSize)
    val tui = new Tui(controll)

    do {
      print("Your input: ")
      input = readLine()
      tui.processInputLine(input)
      print("\n")
    } while (input != "q")
  }
}
