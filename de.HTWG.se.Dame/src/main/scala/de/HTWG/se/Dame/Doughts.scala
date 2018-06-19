package de.HTWG.se.Dame

import scala.io.StdIn.readLine
import de.HTWG.se.Dame.aview.Tui
import de.HTWG.se.Dame.controller.controllerComponent.Controller
import de.HTWG.se.Dame.model.enums.Color
import de.HTWG.se.Dame.model.{Grid, Player}

object Doughts {

  def main(args: Array[String]): Unit = {

    var input: String = ""
    val gridSize = 8
    val grid = new Grid(gridSize)

    val player1 = new Player("Julian", grid, Color.White)
    val player2 = new Player("Patrick", grid, Color.Black)
    val controll = new Controller("Julian", "Patrick", gridSize)
    val tui = new Tui(controll)

    controll.setInitialPiecePosition(player1, player2)
    do {
      println("Your input: ")
      input = readLine()
      tui.processInputLine(input)
    } while (input != "q")
  }
}
