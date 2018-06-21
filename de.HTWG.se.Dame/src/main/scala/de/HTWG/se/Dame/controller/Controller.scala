package de.HTWG.se.Dame.controller.controllerComponent

import de.HTWG.se.Dame.model.enums.{Color, PieceType}
import de.HTWG.se.Dame.model.{Grid, Piece, Player}

import scala.collection.mutable
import scala.util.control.Breaks._
import scala.collection.mutable.ListBuffer

class Controller(p1Name: String, p2Name: String, gridSize: Integer) extends ControllerInterface {

  val grid: Grid = new Grid(gridSize)
  private val player1: Player = new Player(p1Name, grid, Color.Black, 1)
  private val player2: Player = new Player(p2Name, grid, Color.White, 2)
  val pieceCount = ((grid.size - 2) / 2) * (grid.size / 2)

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
      p.x = x;
      p.y = y;
      return true;
    }
    return false;
  }

  def start() = {

    // Gridsize eingeben

    // Name player1 und player2 eingeben

    setInitialPiecePosition(player1, player2);

    // while( ! spiel beendet)

    // Player1 am Zug

    // Player2 am Zug

    // Zeige ergebnis

    // Nochmal ?


  }

  def getPossibleMoves(piece: Piece): List[(Int, Int)] = {
    var list = new ListBuffer[(Int, Int)]()

    if (piece.player == 1) {
      // Player1 bewegt sich in positive richtung
      if (piece.t == PieceType.Men) {

        // kontrollieren, ob ein piece geschlagen werden kann

        list += Tuple2(piece.x + 1, piece.y + 1)
        list += Tuple2(piece.x - 1, piece.y + 1)
      } else {

        // Wenn dame dann alle möglichen positionen auf der diagonalen

      }
    } else {
      // player2 bewegt sich in negative richtung

      if (piece.t == PieceType.Men) {

        // kontrollieren, ob ein piece geschlagen werden kann

        list += Tuple2(piece.x + 1, piece.y - 1)
        list += Tuple2(piece.x - 1, piece.y - 1)
      } else {

        // Wenn dame dann alle möglichen positionen auf der diagonalen

      }

    }
    return list.toList
  }

  def showGrid(): String = {
    return grid.toString()
  }

  def getPlayer(x: Int): Player = {
    if(x == 1)
      return player1
    else if(x == 2)
      return player2
    else
      return null
  }

  override def isOccupied(grid: Grid): Unit = {}

  override def undo: Unit = {}

  override def redo: Unit = {}

  override def save: Unit = {}

  override def load: Unit = {}

}


