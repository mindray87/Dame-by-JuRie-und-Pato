package de.HTWG.se.Dame.controller.controllerComponent
import de.HTWG.se.Dame.model.enums.{Color, PieceType}
import de.HTWG.se.Dame.model.{Grid, Piece, Player}
import scala.util.control.Breaks._

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

    override def setInitialPiecePosition(p1: Player, p2 : Player) : Unit = {
      // TODO: Patrick
      // 2D Array with size Gridsize * Gridsize
      val field = Array.ofDim[Int](gridSize, gridSize)

      // set Stones for player1
      var a = 0
      while (a < gridSize/2 -1) {
        if (a % 2 == 0){
          for(step <- Range(start = 0, end = gridSize, step = 2)) {
            field(a)(step) = 1
            println("feld an der Stelle " + a + step + " " +field(a)(step))
          }

        }
        if (a % 2 == 1){
          for(step <- Range(start = 1, end = gridSize, step = 2)) {
            field(a)(step) = 1
            // debug
            // println("feldungerade an der Stelle " + a + step + " " +field(a)(step))
          }
        }
        a += 1
        //debug
        // println(a)
      }

      // set Stones for player2
      var b = gridSize/2 + 1
      while (b < gridSize) {
        if (b % 2 == 0){
          for(step <- Range(start = 0, end = gridSize, step = 2)) {
            field(b)(step) = 1
            // debug
            // println("feld an der Stelle " + b + step + " " +field(b)(step))
          }

        }
        if (b % 2 == 1){
          for(step <- Range(start = 1, end = gridSize, step = 2)) {
            field(b)(step) = 1
            // debug
            // println("feldungerade an der Stelle " + b + step + " " +field(b)(step))
          }

        }
        b += 1
        // debug
        // println(b)
      }
    }

    def move(x: Int, y: Int, p: Piece) : Unit = {
      // TODO: Julian
    }

    def start() = {
      setInitialPiecePosition(player1, player2);

    }

    def getPossibleMoves(piece : Piece): Unit ={
      if(piece.t == PieceType.Men){

      }else{

      }
    }

    override def isOccupied(grid: Grid): Unit = {}

    override def undo: Unit = {}

    override def redo: Unit = {}

    override def save: Unit = {}

    override def load: Unit = {}

  }


