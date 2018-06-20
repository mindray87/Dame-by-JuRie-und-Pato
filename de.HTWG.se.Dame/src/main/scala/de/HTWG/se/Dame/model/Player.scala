package de.HTWG.se.Dame.model

import de.HTWG.se.Dame.model.enums.Color.Color


case class Player(name: String, grid: Grid, color: Color) {
  override def toString: String = name
  var pieces = new scala.collection.mutable.MutableList[Piece]




}