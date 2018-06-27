package de.HTWG.se.Dame.controller.controllerComponent

import de.HTWG.se.Dame.model.{Grid, Piece, Player}

import scala.collection.mutable
import scala.swing.event.Event



trait ControllerInterface {
  def createPieces(p: Player) : mutable.MutableList[Piece]

  def undo : Unit
  def redo : Unit
  def save : Unit
  def load : Unit
  def getPlayer(x: Int): Player
  def move(src: (Int, Int), dest: (Int, Int)) : Boolean

  def setInitialPiecePosition(p1: Player, p2 : Player) : Unit
  def isOccupied(grid: Grid) : Unit
}

class UpdateEvent extends Event
case class ErrorEvent(message : String) extends Event
case class PrintMovesEvent(position : (Int, Int), moves : List[(Int, Int)]) extends Event