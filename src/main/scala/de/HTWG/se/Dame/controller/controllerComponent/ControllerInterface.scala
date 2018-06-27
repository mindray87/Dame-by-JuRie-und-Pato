package de.HTWG.se.Dame.controller.controllerComponent

import de.HTWG.se.Dame.model.{Grid, Piece, Player}

import scala.collection.mutable
import scala.swing.event.Event



trait ControllerInterface {
  def getGridSize: Int


  def undo : Unit
  def redo : Unit
  def save : Unit
  def load : Unit
  def getPlayer(x: Int): Player
  def move(src: (Int, Int), dest: (Int, Int)) : Boolean
}

class UpdateEvent extends Event
case class ErrorEvent(message : String) extends Event
case class PrintMovesEvent(position : (Int, Int), moves : List[(Int, Int)]) extends Event