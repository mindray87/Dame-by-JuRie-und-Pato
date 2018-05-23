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
      "have a grid size to create pieces" in {

        player.pieces.length should be(((grid.size - 2) / 2) * (grid.size / 2))
      }

      "have the right number of stones set to the specific gridlayout" in {
        player.pieces should be(10, 11)
      }

    }
  }
}