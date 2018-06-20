package de.HTWG.se.Dame.model

import de.HTWG.se.Dame.model.enums.{Color, PieceType}

case class Grid(val size: Int) {
  val field = Array.ofDim[Piece](size, size)
}
