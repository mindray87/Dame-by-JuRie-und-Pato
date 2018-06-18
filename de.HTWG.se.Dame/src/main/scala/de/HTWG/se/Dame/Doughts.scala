package de.HTWG.se.Dame

import scala.io.StdIn.readLine
import de.HTWG.se.Dame.aview.Tui
import de.HTWG.se.Dame.controller.Controller

object Doughts {

  def main(args: Array[String]): Unit = {
    var input: String = ""
    val gridSize = 8
    val tui = new Tui(new Controller("Julian", "Patrick", gridSize))
    do {
      println("Your input: ")
      input = readLine()
      tui.processInputLine(input)
    } while (input != "q")
  }
}
