package de.HTWG.se.Dame.model

import de.HTWG.se.Dame.model.enums.{Color, PieceType}

case class Grid(val size: Int) {


  var cells: scala.collection.immutable.Vector[Cell] = Vector()




  // Create Cells
  for (a: Int <- 1 to size) {
    for (b: Int <- 1 to size) {
      if (a % 2 == 0) {
        if (b % 2 == 0) {
          cells = cells :+ new Cell(Color.White, a, b)
        } else {
          cells = cells :+ new Cell(Color.Black, a, b)
        }
      } else {
        if (b % 2 == 0) {
          cells = cells :+ new Cell(Color.Black, a, b)
        } else {
          cells = cells :+ new Cell(Color.White, a, b)
        }
      }
    }
  }

  def getCell(x: Int, y: Int): Option[Cell] = {

    cells.foreach{
      e=>
        if (e.x == x && e.y == y)
          return Some(e)
    }
    return None
  }



}
