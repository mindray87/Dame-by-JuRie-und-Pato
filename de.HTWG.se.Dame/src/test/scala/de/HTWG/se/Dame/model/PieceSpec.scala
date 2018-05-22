package de.HTWG.se.Dame.model

import de.HTWG.se.Dame.model.enums.PieceType
import org.junit.runner.RunWith
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PieceSpec extends WordSpec with Matchers {
  "A Grid is the figure of Draught. A Piece" when {
    "instanciated" should {
      "be created with the player owning the figure and the type" should {
        val pato = new Player("Pato")
        val juri = new Player("Juri")

        val whitemen = new Piece(pato, PieceType.Men)
        val blackking = new Piece(juri, PieceType.King)

        "should be a king" in {
          blackking.t should be(PieceType.King)
          whitemen.t should be(PieceType.Men)
        }

        "should have the given player" in {
          whitemen.player should be(pato)
          blackking.player should be(juri)
        }
      }
    }
  }
}