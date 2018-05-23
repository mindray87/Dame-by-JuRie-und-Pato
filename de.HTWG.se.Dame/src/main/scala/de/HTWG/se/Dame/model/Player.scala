package de.HTWG.se.Dame.model

import de.HTWG.se.Dame.model.enums.Color.Color
import de.HTWG.se.Dame.model.enums.PieceType


case class Player(name: String, grid: Grid, color: Color) {
  override def toString: String = name
  var pieces: scala.collection.immutable.Vector[Piece] = Vector()
  // Create Pieces per Player
  val countPieces = ((grid.size - 2) / 2) * (grid.size / 2)
  for (a <- 1 to countPieces) {
    pieces = pieces :+ new Piece(this, PieceType.Men)
  }



}