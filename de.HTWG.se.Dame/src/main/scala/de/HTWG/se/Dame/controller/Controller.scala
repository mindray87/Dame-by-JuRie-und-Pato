package de.HTWG.se.Dame.controller.controllerComponent
import de.HTWG.se.Dame.model.enums.{Color, PieceType}
import de.HTWG.se.Dame.model.{Grid, Piece, Player}
import de.HTWG.se.Dame.controller.controllerComponent.ControllerInterface


  class Controller (p1Name : String, p2Name : String, gridSize : Integer) extends ControllerInterface{

    val grid : Grid = new Grid(gridSize)
    val player1 : Player = new Player(p1Name, grid, Color.Black)
    val player2 : Player = new Player(p2Name, grid, Color.White)
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

    def move(x: Int, y: Int, p: Piece) : Unit = {

    }

    def start() = {

    }

    def getPossibleMoves(piece : Piece): Unit ={
      if(piece.t == PieceType.Men){

      }else{

      }
    }




    override def undo: Unit = {}

    override def redo: Unit = {}

    override def save: Unit = {}

    override def load: Unit = {}

    override def move: Unit = {}

    override def possibleMovement: Unit = {}


  }


