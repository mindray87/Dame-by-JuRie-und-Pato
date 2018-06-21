package de.HTWG.se.Dame.controller.controllerComponent

import de.HTWG.se.Dame.model.enums.{Color, GameState, PieceType}
import de.HTWG.se.Dame.model.{Grid, Piece, Player}

import scala.collection.mutable
import scala.util.control.Breaks._
import scala.collection.mutable.ListBuffer

class Controller(p1Name: String, p2Name: String, gridSize: Integer) extends ControllerInterface {

  val grid: Grid = new Grid(gridSize)
  val player1: Player = new Player(p1Name, grid, Color.Black)
  val player2: Player = new Player(p2Name, grid, Color.White)
  val pieceCount = ((grid.size - 2) / 2) * (grid.size / 2)
  var gameState = GameState.Player1

  player1.pieces = createPieces(player1)
  player2.pieces = createPieces(player2)

  start()

  override def createPieces(p: Player): mutable.MutableList[Piece] = {
    var pieces = new mutable.MutableList[Piece]
    for (a <- 1 to pieceCount) {
      pieces += (new Piece(p.number, PieceType.Men))
    }
    return pieces;
  }

  override def setInitialPiecePosition(p1: Player, p2: Player): Unit = {

    // TODO: Clear the field


    // set Stones for player1
    var p1PieceCount: Int = 0
    var a = 0
    while (a < (gridSize / 2) - 1) {
      if (a % 2 == 0) {
        for (step <- Range(start = 0, end = gridSize, step = 2)) {
          grid.field(a)(step) = p1.pieces.apply(p1PieceCount)
          p1PieceCount += 1
        }
      }
      if (a % 2 == 1) {
        for (step <- Range(start = 1, end = gridSize, step = 2)) {
          grid.field(a)(step) = p1.pieces.apply(p1PieceCount)
          p1PieceCount += 1
        }
      }
      a += 1
    }

    // set Stones for player2

    var p2PieceCount = 0
    var b = gridSize / 2 + 1
    while (b < gridSize) {

      if (b % 2 == 0) {
        for (step <- Range(start = 0, end = gridSize, step = 2)) {
          grid.field(b)(step) = p2.pieces.apply(p2PieceCount)
          p2PieceCount += 1
        }
      }
      if (b % 2 == 1) {
        for (step <- Range(start = 1, end = gridSize, step = 2)) {
          grid.field(b)(step) = p2.pieces.apply(p2PieceCount)
          p2PieceCount += 1
        }
      }
      b += 1
    }
  }


  def move(x: Int, y: Int, p: Piece): Boolean = {
    val list = getPossibleMoves(p)
    if (list.contains(Tuple2(x, y))) {
      val n = grid.getCoordinates(p)
      grid.field(n._1)(n._2) = null
      grid.field(x)(y) = p
      return true;
    }
    return false;
  }

  def start() = {

    // Gridsize eingeben

    // Name player1 und player2 eingeben

    setInitialPiecePosition(player1, player2);


  }

  def getMessage(): String ={
    gameState match{
      case GameState.Player1 => return "It's " + player1.name + "'s turn. Please choose a piece."
      case GameState.Player2 => return "It's " + player2.name + "'s turn. Please choose a piece."
    }

  }

  def getPossibleMoves(x : Int, y : Int) : List[(Int, Int)] = {
    return getPossibleMoves(grid.getPiece(x,y))
  }

  def getPossibleMoves(piece: Piece): List[(Int, Int)] = {
    var list = new ListBuffer[(Int, Int)]()

    if (piece.player == 1) {
      // Player1 bewegt sich in positive richtung
      if (piece.t == PieceType.Men) {

        // kontrollieren, ob ein piece geschlagen werden kann

        val coo = grid.getCoordinates(piece)
        list += Tuple2(coo._1 + 1, coo._2 + 1)
        list += Tuple2(coo._1  - 1, coo._2 + 1)
      } else {

        // Wenn dame dann alle möglichen positionen auf der diagonalen

      }
    } else {
      // player2 bewegt sich in negative richtung

      if (piece.t == PieceType.Men) {

        // kontrollieren, ob ein piece geschlagen werden kann

        val coo = grid.getCoordinates(piece)
        println(coo)
        list += Tuple2(coo._1 + 1, coo._2 + 1)
        list += Tuple2(coo._1 - 1, coo._2 - 1)
      } else {

        // Wenn dame dann alle möglichen positionen auf der diagonalen

      }

    }
    return list.toList
  }

  def updateGameState(): Unit = {
    // TODO: Implement
  }

  def showGrid(): String = {
    return grid.toString()
  }

  override def isOccupied(grid: Grid): Unit = {}

  override def undo: Unit = {}

  override def redo: Unit = {}

  override def save: Unit = {}

  override def load: Unit = {}

}


