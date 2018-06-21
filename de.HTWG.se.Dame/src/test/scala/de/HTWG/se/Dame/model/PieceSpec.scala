package de.HTWG.se.Dame.model

import de.HTWG.se.Dame.model.enums.{Color, PieceType}
import org.junit.runner.RunWith
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PieceSpec extends WordSpec with Matchers {
  "A Grid is the figure of Draught. A Piece" when {
    "instanciated" should {
      "be created with the player owning the figure and the type" should {
        val grid = new Grid(12)
        val pato = new Player("Pato", grid, Color.White, 1)
        val juri = new Player("Juri", grid, Color.White, 2)

        val whitemen = new Piece(pato.number, PieceType.Men)
        val blackking = new Piece(juri.number, PieceType.King)

        "should be a king" in {
          blackking.t should be(PieceType.King)
          whitemen.t should be(PieceType.Men)
        }

        "should have the given player" in {
          whitemen.player should be(1)
          blackking.player should be(2)
        }
      }
    }
  }
}