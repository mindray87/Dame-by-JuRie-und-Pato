package de.HTWG.se.Dame.model

import de.HTWG.se.Dame.controller.controllerComponent.Controller
import de.HTWG.se.Dame.model.enums.{Color, PieceType}
import org.junit.runner.RunWith
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PieceSpec extends WordSpec with Matchers {
  "A Piece is the figure of Draught. A Piece" when {
    "instanciated" should {
      "be created with the player owning the figure and the type" should {
        val controll = new Controller("jul", "pat", 10)
        val player1 = controll.getPlayer(1)
        val player2 = controll.getPlayer(2)


        val whiteking = new Piece(player1.number, PieceType.King)
        val blackking = new Piece(player2.number, PieceType.King)
        val whitemen = new Piece(player1.number, PieceType.Men)
        val blackmen = new Piece(player2.number, PieceType.Men)

        "should be a king" in {
          blackking.t should be(PieceType.King)
          whiteking.t should be(PieceType.King)
        }

        "should be a men" in {
          blackmen.t should be (PieceType.Men)
          whitemen.t should be (PieceType.Men)
        }

        "should have the given player" in {
          whiteking.player should be(1)
          whitemen.player should be(1)
          blackmen.player should be(2)
          blackking.player should be(2)
        }

        "new Object should look like this" in {
          new Piece(player1.number, PieceType.King) should be(Piece(1,PieceType.King))
        }

        "Piece of a Player not instanciated" in {
          player
        }

      }
    }
  }
}