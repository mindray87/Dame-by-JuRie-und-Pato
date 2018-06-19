package de.HTWG.se.Dame.model

import de.HTWG.se.Dame.model.enums.PieceType.PieceType



case class Piece(val player: Player, t: PieceType) {

  var x : Int = -1
  var y : Int = -1
}
