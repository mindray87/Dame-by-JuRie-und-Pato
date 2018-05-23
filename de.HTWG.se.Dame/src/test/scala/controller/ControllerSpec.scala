package controller

import de.HTWG.se.Dame.controller.Controller
import de.HTWG.se.Dame.model.enums.Color
import de.HTWG.se.Dame.model.{Cell, Grid, Piece, Player}
import org.scalatest.{Matchers, WordSpec}

class ControllerSpec extends WordSpec with Matchers{
  "A move is valid" when {
    "the destinationcell is empty" should {
      val grid = new Grid(8)
      val player = new Player("Hansi", grid, Color.White)
      val controller = new Controller(grid)
      "move" in {
        controller.move(4, 4, player.pieces(0))
        val opt = grid.getCell(4, 4)
        opt.get.piece should be(Some(player.pieces(0)))
      }
    }
  }
}
