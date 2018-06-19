package de.HTWG.se.Dame.controller.controllerComponent

import de.HTWG.se.Dame.model.enums.{Color, PieceType}
import de.HTWG.se.Dame.model.{Grid, Piece, Player}

import scala.collection.mutable.ListBuffer

class Controller(p1Name: String, p2Name: String, gridSize: Integer) extends ControllerInterface {

  val grid: Grid = new Grid(gridSize)
  val player1: Player = new Player(p1Name, grid, Color.Black)
  val player2: Player = new Player(p2Name, grid, Color.White)
  val initialPieceCount = ((grid.size - 2) / 2) * (grid.size / 2)

  player1.pieces = createPieces(player1)
  player2.pieces = createPieces(player2)

  override def createPieces(p: Player): Vector[Piece] = {
    var pieces: scala.collection.immutable.Vector[Piece] = Vector()
    for (a <- 1 to initialPieceCount) {
      pieces = pieces :+ new Piece(p, PieceType.Men)
    }
    return pieces;
  }

  def setInitialPiecePosition(p1: Player, p2: Player): Unit = {
    // TODO: Patrick
  }

  def move(x: Int, y: Int, p: Piece): Boolean = {
    val list = getPossibleMoves(p)
    if(list.contains(Tuple2(x,y))){
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

    if(piece.player.equals(player1)) {
      // Player1 bewegt sich in positive richtung
      if (piece.t == PieceType.Men) {

        // kontrollieren, ob ein piece geschlagen werden kann

        list += Tuple2(piece.x + 1, piece.y + 1)
        list += Tuple2(piece.x - 1, piece.y + 1)
      } else {

        // Wenn dame dann alle möglichen positionen auf der diagonalen

      }
    }else{
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

  override def undo: Unit = {}

  override def redo: Unit = {}

  override def save: Unit = {}

  override def load: Unit = {}

}


