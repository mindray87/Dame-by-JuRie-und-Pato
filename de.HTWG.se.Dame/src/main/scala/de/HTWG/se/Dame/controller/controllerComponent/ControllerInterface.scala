package de.HTWG.se.Dame.controller.controllerComponent

import de.HTWG.se.Dame.model.{Grid, Piece, Player}




trait ControllerInterface {
  def grid : Grid

  def player1 : Player
  def player2 : Player

  def createPieces(p: Player) : Vector[Piece]

  def undo : Unit
  def redo : Unit
  def save : Unit
  def load : Unit

  def move(x: Int, y: Int, p: Piece) : Boolean
  def getPossibleMoves(piece : Piece) : List[(Int, Int)]

}