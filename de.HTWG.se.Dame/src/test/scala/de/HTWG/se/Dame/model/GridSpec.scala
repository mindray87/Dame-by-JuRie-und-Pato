package de.HTWG.se.Dame.model

import org.junit.runner.RunWith
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GridSpec extends WordSpec with Matchers {
  "A Grid is the playingfield of Draught. A Grid" when {
    "instanciated" should {
      "be created with the length of its edges as size. Practically relevant are size 8, 10, and 12" should {
        val smallgrid = new Grid(8)
        val mediumgrid = new Grid(10)
        val biggrid = new Grid(12)
        val unevengrid = new Grid(15)


        "have given size" in {
          biggrid.size should be(12)
        }

        "have a getCell Method that returns the x & y coordinate of the cell" in {
          val opt: Option[Cell] =  biggrid.getCell(4, 4)
          biggrid.getCell(15, 5) should be(None)
          opt.get.x should be(4)


        }
      }
    }
  }
}

