package de.HTWG.se.Dame.model

import de.HTWG.se.Dame.controller.controllerComponent.Controller
import de.HTWG.se.Dame.model.enums.Color
import org.junit.runner.RunWith
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.junit.JUnitRunner

import scala.collection.mutable

@RunWith(classOf[JUnitRunner])
class GridSpec extends WordSpec with Matchers {
  "A Grid is the playingfield of Draught. A Grid" when {
    "instanciated" should {
      val smallgrid = new Grid(8)
      val mediumgrid = new Grid(10)
      val biggrid = new Grid(12)
      val unevengrid = new Grid(15)
      "be created with the length of its edges as size. Practically relevant are size 8, 10, and 12" should {
        "have given size" in {
          biggrid.size should be(12)
          smallgrid.size should be(8)
          mediumgrid.size should be(10)
          unevengrid.size should be (15)
        }
      }
    }
    "nicely printed" in {
      val controll = new Controller("jul", "pat", 10)
      val p1 = controll.getPlayer(1)
      val p2 = controll.getPlayer(2)
      controll.setInitialPiecePosition(p1, p2)

      val s = "| O |   | O |   | O |   | O |   | O |   |\n|   | O |   | O |   | O |   | O |   | O |\n| O |   | O |   | O |   | O |   | O |   |\n|   | O |   | O |   | O |   | O |   | O |\n|   |   |   |   |   |   |   |   |   |   |\n|   |   |   |   |   |   |   |   |   |   |\n| X |   | X |   | X |   | X |   | X |   |\n|   | X |   | X |   | X |   | X |   | X |\n| X |   | X |   | X |   | X |   | X |   |\n|   | X |   | X |   | X |   | X |   | X |\n"

      controll.showGrid() should be (s)
    }
    "print the numbers of each gridcell" in {
      val controll = new Controller("jul", "pat", 10)
      val p1 = controll.getPlayer(1)
      val p2 = controll.getPlayer(2)
      p1.pieces = controll.createPieces(p1)
      p2.pieces = controll.createPieces(p2)
      controll.setInitialPiecePosition(p1, p2)

      val s = "| 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 |\n| 10 | 11 | 12 | 13 | 14 | 15 | 16 | 17 | 18 | 19 |\n| 20 | 21 | 22 | 23 | 24 | 25 | 26 | 27 | 28 | 29 |\n| 30 | 31 | 32 | 33 | 34 | 35 | 36 | 37 | 38 | 39 |\n| 40 | 41 | 42 | 43 | 44 | 45 | 46 | 47 | 48 | 49 |\n| 50 | 51 | 52 | 53 | 54 | 55 | 56 | 57 | 58 | 59 |\n| 60 | 61 | 62 | 63 | 64 | 65 | 66 | 67 | 68 | 69 |\n| 70 | 71 | 72 | 73 | 74 | 75 | 76 | 77 | 78 | 79 |\n| 80 | 81 | 82 | 83 | 84 | 85 | 86 | 87 | 88 | 89 |\n| 90 | 91 | 92 | 93 | 94 | 95 | 96 | 97 | 98 | 99 |\n"

      controll.grid.showGridNumbers should be (s)

    }
  }
}



