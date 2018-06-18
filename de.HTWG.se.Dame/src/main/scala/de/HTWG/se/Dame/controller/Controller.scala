package de.HTWG.se.Dame.controller
import de.HTWG.se.Dame.model.enums.{Color, PieceType}
import de.HTWG.se.Dame.model.{Grid, Piece, Player}

  class Controller (p1Name : String, p2Name : String, gridSize : Integer){

    val grid : Grid = new Grid(gridSize)
    val p1 : Player = new Player(p1Name, grid, Color.Black)
    val p2 : Player = new Player(p2Name, grid, Color.White)
    val initialPieceCount = ((grid.size - 2) / 2) * (grid.size / 2)

    p1.pieces = createPieces(p1)
    p2.pieces = createPieces(p2)

    def createPieces(p : Player) : Vector[Piece] = {
      var pieces: scala.collection.immutable.Vector[Piece] = Vector()
      for (a <- 1 to initialPieceCount) {
        pieces = pieces :+ new Piece(p, PieceType.Men)
      }
      return pieces;
    }


    def move(x: Int, y: Int, p: Piece) : Unit = {
      val opt = grid.getCell(x, y)
      opt.get.piece = Option(p)
      print()
    }

    def start() = {

    }

    def getPossibleMoves(piece : Piece): Unit ={
      if(piece.t == PieceType.Men){

      }else{

      }
    }
  }


