package de.HTWG.se.Dame

import de.HTWG.se.Dame.model.{Grid, Player}

object Doughts {
  val gridSize = 8


  def main(args: Array[String]): Unit = {
    val a = new Grid(8)
    println(a.cells)
    val student = Player("Your Name")
    println("Hello, " + student.name)
  }
}
