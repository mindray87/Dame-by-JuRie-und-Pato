package de.HTWG.se.Dame.controller

import de.HTWG.se.Dame.controller.Controller
import org.scalatest.{Matchers, WordSpec}

class ControllerSpec extends WordSpec with Matchers{
  "A move is valid" when {
    "the destinationcell is empty" should {
      val controller = new Controller("Julian", "Patrick", 8)
      "move" in {
//        controller.move(4, 4, controller.p1.pieces(0))
 //       val opt = controller.grid.getCell(4, 4)
 //       opt.get.piece should be(Some(controller.p1.pieces(0)))
      }
    }
  }
}
