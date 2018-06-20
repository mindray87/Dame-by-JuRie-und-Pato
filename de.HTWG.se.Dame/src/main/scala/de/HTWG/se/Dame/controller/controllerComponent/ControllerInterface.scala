package de.HTWG.se.Dame.controller.controllerComponent

import de.HTWG.se.Dame.model.{Grid, Piece, Player}

import scala.collection.mutable




trait ControllerInterface {
  def grid : Grid

  def player1 : Player
  def player2 : Player

  def createPieces(p: Player) : mutable.MutableList[Piece]

  def undo : Unit
  def redo : Unit
  def save : Unit
  def load : Unit

  def move(x: Int, y: Int, p: Piece) : Boolean
  def getPossibleMoves(piece : Piece) : List[(Int, Int)]

  def setInitialPiecePosition(p1: Player, p2 : Player) : Unit
  def isOccupied(grid: Grid) : Unit
}