package de.htwg.se.dame.controller.controllerComponent

object GameStatus extends Enumeration{
  type GameStatus = Value
  val IDLE, RESIZE, SET, NEW, UNDO, REDO, LOADED, COULDNOTLOAD, SAVED, CANDIDATES, SOLVED, NOT_SOLVABLE = Value

  val map = Map[GameStatus, String](
    IDLE -> "",
    NEW -> "A new game was created",
    SET -> "A Cell was set",
    RESIZE -> "Game was resized",
    UNDO -> "Undone one step",
    CANDIDATES -> "Showing candidates",
    REDO -> "Redone one step",
    LOADED ->"A new Game was loaded",
    COULDNOTLOAD -> "The file could not be loaded",
    SAVED ->  "The Game was saved")

  def message(gameStatus: GameStatus) = {
    map(gameStatus)
  }

}