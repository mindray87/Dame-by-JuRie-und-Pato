package de.HTWG.se.Dame

import de.HTWG.se.Dame.model.enums.Color
import de.HTWG.se.Dame.model.{Grid, Player}

import scala.io.StdIn.readLine

object Doughts {

  def main(args: Array[String]): Unit = {
    var input: String = ""

    do {
      input = readLine()
      tui.processInputLine(input)
    } while (input != "q")

    val student = Player("Your Name", a, Color.White)
    println("Hello, " + student.name)
  }
}
