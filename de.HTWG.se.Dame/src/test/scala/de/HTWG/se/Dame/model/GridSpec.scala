package de.HTWG.se.Dame.model

import org.junit.runner.RunWith
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GridSpec extends WordSpec with Matchers {
  "A Grid is the playingfield of Draught. A Grid" when {
    "instanciated" should {
      "be created with the length of its edges as size. Practically relevant are size 8, 10, and 12" in {
        val smallgrid = new Grid(8)
        val mediumgrid = new Grid(10)
        val biggrid = new Grid(12)

        "have a even size" in {
          (smallgrid.size % 2 == 0) should be(true)
        }
        "have given size" in {
          biggrid.size should be(12)
        }
      }
    }
  }
}

