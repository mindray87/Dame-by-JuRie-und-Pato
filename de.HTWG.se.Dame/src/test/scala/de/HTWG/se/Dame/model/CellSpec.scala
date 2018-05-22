package de.HTWG.se.Dame.model

import de.HTWG.se.Dame.model.enums.{Color, PieceType}
import org.junit.runner.RunWith
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CellSpec extends WordSpec with Matchers {
  "A cell is the smallest part of the draught playfield" when {
    "instanciated" should {
      "have a color and the given coordinates" should {
        val whitecell = new Cell(Color.White, 9, 4)
        val blackcell = new Cell(Color.Black, 3, 5)


        "have given color" in {
          whitecell.color should be(Color.White)
          blackcell.color should be(Color.Black)
        }

        "have given coordinates" in {
          blackcell.x should be(3)
          blackcell.y should be(5)
          whitecell.x should be(9)
          whitecell.y should be(4)
        }

        "empy cell" in {
          blackcell.piece should be(None)
          whitecell.piece should be(None)
        }

        "test piece" in {
          val p = new Piece(new Player("Pato"), PieceType.Men)
          blackcell.piece = Some(p)
          blackcell.piece should be(Some(p))

          val q = new Piece(new Player("Juri"), PieceType.King)
          blackcell.piece = Some(q)
          blackcell.piece should be(Some(q))
        }
      }
    }
  }
}
