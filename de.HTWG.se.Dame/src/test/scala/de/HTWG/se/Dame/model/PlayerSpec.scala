package de.HTWG.se.Dame.model

import de.HTWG.se.Dame.controller.controllerComponent.Controller
import de.HTWG.se.Dame.model.enums.Color
import org.junit.runner.RunWith
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PlayerSpec extends WordSpec with Matchers {
  "A Player" when {
    "new" should {
      val controll = new Controller("jul", "pat", 10)
      val player = controll.getPlayer(1)
      "have a name" in {
        player.name should be("jul")
      }
      "have a nice String representation" in {
        player.toString should be("jul")
      }
      "have a game color" in {
        player.color should be (Color.Black)
      }
      "have a list to save pieces" in {
        player.pieces.length should be(20)
      }
      "first player should have the number 1" in {
        player.number should be(1)
      }

    }
  }
}