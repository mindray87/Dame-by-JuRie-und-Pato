package de.HTWG.se.Dame.model

import de.HTWG.se.Dame.model.enums.{Color, PieceType}

case class Grid(val size: Int) {


  var cells: scala.collection.immutable.Vector[Cell] = Vector()
  var pieces: scala.collection.immutable.Vector[Piece] = Vector()
  val p0 = new Player("Patrick")
  val p1 = new Player("Julian")


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

  // Create Pieces per Player
  val countPieces = ((size - 2) / 2) * (size / 2)
  for (a <- 1 to countPieces) {
    pieces = pieces :+ new Piece(p0, PieceType.Men)
    pieces = pieces :+ new Piece(p1, PieceType.Men)
  }

}
