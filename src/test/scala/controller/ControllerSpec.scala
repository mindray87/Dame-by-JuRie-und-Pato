package de.HTWG.se.Dame.controller.controllerComponent


import org.scalatest.{Matchers, WordSpec}

class ControllerSpec extends WordSpec with Matchers {
  "A move is valid" when {
    "the destinationcell is empty" should {
      val controller = new Controller("Julian", "Patrick", 8)
      controller.init
      "move" in {
        val p = controller.getPiece(2, 4).get
        controller.move((2, 4), (3, 5))
        val opt = controller.getPiece(3, 5)
        opt.get should be(p)
      }

      "helper" in {
        // TODO
      }
    }
  }
}
