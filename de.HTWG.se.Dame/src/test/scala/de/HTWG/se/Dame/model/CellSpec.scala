package de.HTWG.se.Dame.model

import de.HTWG.se.Dame.model.enums.Color
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class CellSpec extends WordSpec with Matchers {

  "A Cell" when {
    "not set to any value " should {
      val emptyCell = Cell(Color.White, 0, 0)
      "have value 0" in {
        emptyCell.x should be(0)
      }
      "has color white" in {
        emptyCell.color should be(Color.White)
      }
    }
    "set to a specific value" should {
      val nonEmptyCell = Cell(Color.Black, 5, 6)
      "return that value" in {
        nonEmptyCell.x should be(5)
      }
      "return that value" in {
        nonEmptyCell.y should be(6)
      }
      "has color black" in {
        nonEmptyCell.color should be(Color.Black)
      }
    }
  }

}