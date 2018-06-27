package de.HTWG.se.Dame.model

import de.HTWG.se.Dame.controller.controllerComponent.Controller
import de.HTWG.se.Dame.model.enums.Color
import de.HTWG.se.Dame.model.enums.Color.Color
import org.junit.runner.RunWith
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.junit.JUnitRunner

import scala.collection.mutable

@RunWith(classOf[JUnitRunner])
class PlayerSpec extends WordSpec with Matchers {
  "A Player" when {
    "new" should {
      val controll = new Controller("jul", "pat", 10)
      controll.init
      val player1 = controll.getPlayer(1)
      val player2 = controll.getPlayer(2)
      val s = "| O |   | O |   | O |   | O |   | O |   |\n|   | O |   | O |   | O |   | O |   | O |\n| O |   | O |   | O |   | O |   | O |   |\n|   | O |   | O |   | O |   | O |   | O |\n|   |   |   |   |   |   |   |   |   |   |\n|   |   |   |   |   |   |   |   |   |   |\n| X |   | X |   | X |   | X |   | X |   |\n|   | X |   | X |   | X |   | X |   | X |\n| X |   | X |   | X |   | X |   | X |   |\n|   | X |   | X |   | X |   | X |   | X |\n"
      "have a name" in {
        player1.name should be("jul")
        player2.name should be("pat")
      }
      "have a nice String representation" in {
        player1.toString should be(player1.name)
        player2.toString should be("pat")
      }
      "have a game color" in {
        player1.color should be (Color.Black)
        player2.color should be (Color.White)
      }
      "have a list to save pieces" in {
        player1.pieces.length should be(20)
        player2.pieces.length should be(20)
      }
      "have a list to save the pieces" in{
        player1.pieces.isInstanceOf[mutable.MutableList[_]] should be(true)
      }
      "first player should have the number 1" in {
        player1.number should be(1)
        player2.number should be(2)
      }

      "types" in {
        player1.name.isInstanceOf[String] should be(true)
        player1.grid.isInstanceOf[Grid] should be(true)
        player1.color.isInstanceOf[Color] should be(true)
        player1.number.isInstanceOf[Int] should be(true)
      }

      "should be created with the arguments " in {

      }
    }
  }
}