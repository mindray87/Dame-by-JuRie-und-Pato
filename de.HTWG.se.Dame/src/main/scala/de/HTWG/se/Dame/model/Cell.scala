
package de.HTWG.se.Dame.model

import de.HTWG.se.Dame.model.enums.Color.Color


case class Cell(color: Color, val x: Int, val y: Int) {
  var piece = None: Option[Piece]
}

