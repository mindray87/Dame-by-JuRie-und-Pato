package de.HTWG.se.Dame.controller.controllerComponent

import de.HTWG.se.Dame.model.enums.{Color, GameState, PieceType}
import de.HTWG.se.Dame.model.{Grid, Piece, Player}

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.swing.Publisher

class Controller(p1Name: String, p2Name: String, gridSize: Integer) extends ControllerInterface with Publisher {


  private val grid: Grid = new Grid(gridSize)
  private val player1: Player = new Player(p1Name, grid, Color.Black, 1)
  private val player2: Player = new Player(p2Name, grid, Color.White, 2)
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
    // set Stones for player1
    var p1PieceCount: Int = 0
    var a = 0
    while (a < (gridSize / 2) - 1) {
      if (a % 2 == 0) {
        for (step <- Range(start = 0, end = gridSize, step = 2)) {
          grid.field(a)(step) = Some(p1.pieces.apply(p1PieceCount))
          p1PieceCount += 1
        }
      }
      if (a % 2 == 1) {
        for (step <- Range(start = 1, end = gridSize, step = 2)) {
          grid.field(a)(step) = Some(p1.pieces.apply(p1PieceCount))
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
          grid.field(b)(step) = Some(p2.pieces.apply(p2PieceCount))
          p2PieceCount += 1
        }
      }
      if (b % 2 == 1) {
        for (step <- Range(start = 1, end = gridSize, step = 2)) {
          grid.field(b)(step) = Some(p2.pieces.apply(p2PieceCount))
          p2PieceCount += 1
        }
      }
      b += 1
    }
    publish(new UpdateUI)
  }


  def showGridNumbers(): String = {
    return grid.showGridNumbers.toString
  }

  def getPiece(x: Int, y: Int): Option[Piece] = {
    return grid.getPiece(x, y)
  }

  def getPiece(n: (Int, Int)): Option[Piece] = {
    return grid.getPiece(n._1, n._2)
  }

  def getCoordinates(p: Piece): Option[(Int, Int)] = {
    return grid.getCoordinates(p)
  }

  def move(dest: (Int, Int), p: Piece): Boolean = {
    val list = getPossibleMoves(p)
    if (list.contains(dest)) {
      grid.getCoordinates(p) match {
        case None => return false
        case Some(src) =>
          grid.field(src._1)(src._2) = None
          grid.field(dest._1)(dest._2) = Some(p)

          val step_x = getStep(src._1, dest._1)
          val step_y = getStep(src._2, dest._2)
          var t = src._1 + step_x
          var q = src._2 + step_y

          for (a <- Range(0, math.abs(src._1 - dest._1) - 1)) {

            grid.field(t)(q) match {
              case Some(p) => grid.field(t)(q) = None
              case None => println("no piece on " + t + "," + q)
              case _ =>
            }

            t += step_x
            q += step_y

          }
          publish(new UpdateUI)
          return true
      }
    }
    return false;
  }

  private def getStep(s: Int, d: Int): Int = {
    if (s <= d) {
      return +1
    } else {
      return -1
    }
  }

  def start() = {

    // Gridsize eingeben

    // Name player1 und player2 eingeben

    setInitialPiecePosition(player1, player2);


  }

  def getMessage(): String = {
    gameState match {
      case GameState.Player1 => return "It's " + player1.name + "'s turn. Please choose a piece."
      case GameState.Player2 => return "It's " + player2.name + "'s turn. Please choose a piece."
    }
  }

  def getPossibleMoves(x: Int, y: Int): List[(Int, Int)] = {
    getPiece(x, y) match {
      case Some(p) => return getPossibleMoves(p)
      case _ => return Nil
    }
  }

  def getPossibleMoves(piece: Piece): List[(Int, Int)] = {
    var list = new ListBuffer[(Int, Int)]()

    if (piece.player == 1) { // Player1 bewegt sich in positive richtung
      if (piece.t == PieceType.Men) {
        grid.getCoordinates(piece) match {
          case None =>
          case Some(coo) =>
            getPossibleMovesHelper(player1.number, coo._1, coo._2, 1, 1, list)
            getPossibleMovesHelper(player1.number, coo._1, coo._2, 1, -1, list)
        }
      } else {

        // Wenn dame dann alle möglichen positionen auf der diagonalen

      }
    } else { // player2 bewegt sich in negative richtung
      if (piece.t == PieceType.Men) {
        grid.getCoordinates(piece) match {
          case Some(coo) =>
            getPossibleMovesHelper(player2.number, coo._1, coo._2, -1, 1, list)
            getPossibleMovesHelper(player2.number, coo._1, coo._2, -1, -1, list)
          case None =>
        }
      } else {

        // Wenn dame dann alle möglichen positionen auf der diagonalen
      }
    }
    return list.toList
  }

  private def getPossibleMovesHelper(player: Int, x: Int, y: Int, step_x: Int, step_y: Int, list: mutable.ListBuffer[(Int, Int)]): Unit = {
    if (grid.outOfBounds((x + step_x, y + step_y))) {
      return
    }
    getPiece(x + step_x, y + step_y) match {
      case Some(p) => if (!possibleJump((x, y), step_x, step_y, player)) return
      else {
        if (!possibleJump((x + step_x + step_x, y + step_y + step_y), step_x, step_y, player)) {
          list += Tuple2(x + step_x + step_x, y + step_y + step_y)
        } else {
          getPossibleMovesHelper(player, x + step_x + step_x, y + step_y + step_y, step_x, step_y, list)
        }
      }
      case None =>
        list += Tuple2(x + step_x, y + step_y)
    }
  }


  private def possibleJump(src: (Int, Int), step_x: Int, step_y: Int, p_number: Int): Boolean = {
    // Ist sprung über einen Gegener möglich
    if (grid.outOfBounds((src._1 + step_x + step_x, src._2 + step_y + step_y))) return false
    val one = getPiece(src._1 + step_x, src._2 + step_y)
    val two = getPiece(src._1 + step_x + step_x, src._2 + step_y + step_y)
    one match {
      case None => return false
      case Some(p) =>
        if (p.player != p_number && two == None)
          return true
        else
          return false
    }
  }


  def updateGameState(): Unit = {
    // TODO: Implement
  }

  def showGrid(): String = {
    return grid.toString()
  }

  def showGrid(i: (Int, Int), list: List[(Int, Int)]): String = {
    return grid.toString(i, list)
  }

  def getPlayer(x: Int): Player = {
    x match {
      case 1 => return player1
      case 2 => return player2
      case _ => return null
    }
  }

  override def isOccupied(grid: Grid): Unit = {}

  override def undo: Unit = {}

  override def redo: Unit = {}

  override def save: Unit = {}

  override def load: Unit = {}

}


