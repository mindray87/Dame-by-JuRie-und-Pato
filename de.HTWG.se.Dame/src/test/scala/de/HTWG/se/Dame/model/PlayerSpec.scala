package de.HTWG.se.Dame.model

import de.HTWG.se.Dame.model.enums.Color
import org.junit.runner.RunWith
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PlayerSpec extends WordSpec with Matchers {
  "A Player" when {
    "new" should {
      val grid = new Grid(12)
      val player = Player("Your Name", grid, Color.Black)
      "have a name" in {
        player.name should be("Your Name")
      }
      "have a nice String representation" in {
        player.toString should be("Your Name")
      }
      "have a game color" in {
        player.color should be (Color.Black)
      }
      "have a list to save pieces" in {
        player.pieces.length should be(0)
      }
      "first player should have the number 1" in {
        player.number should be(1)
      }

    }
  }
}