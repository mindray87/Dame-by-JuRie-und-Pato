package de.HTWG.se.Dame.controller
import de.HTWG.se.Dame.model.{Grid, Piece}

  class Controller (grid: Grid){

    def move(x: Int, y: Int, p: Piece) = {
      val opt = grid.getCell(x, y)
      opt.get.piece = Option(p)
      print()
    }
  }


