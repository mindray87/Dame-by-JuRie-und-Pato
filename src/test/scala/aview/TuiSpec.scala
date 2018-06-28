package aview

import de.HTWG.se.Dame.aview.Tui
import de.HTWG.se.Dame.controller.controllerComponent.Controller
import de.HTWG.se.Dame.model.enums.Color
import de.HTWG.se.Dame.model.enums.Color.Color
import org.junit.runner.RunWith
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.junit.JUnitRunner

import scala.collection.mutable

@RunWith(classOf[JUnitRunner])
class TuiSpec  extends WordSpec with Matchers {
  "A Doughts Tui" should {
    val controller = new Controller("jul", "pat", 8)
    val tui = new Tui(controller)
    controller.init
    "output the grid with numbers" in {
      val s = tui.processInputLine("info")
      println(controller.showGridNumbers()) should be(s)
    }
    "output goodbye on input 'q'" in {
      val result = tui.processInputLine("q")
      result should be(tui.processInputLine("q"))
    }
    "start a move" in {
      val result = tui.processInputLine("move 24 33")
      result should be(tui.processInputLine("move 24 33"))
    }
    "choose a Piece" in {
      val result = tui.processInputLine("choose 5")
      result should be(tui.processInputLine("choose 5"))
    }
    "tell you when its not your turn" in {
      val result = tui.processInputLine("move 00 11")
      result should be (tui.processInputLine("move 00 11"))
    }
    "tell you when you try to do an invalid move" in {
      val result = tui.processInputLine("move 60 65")
      result should be (tui.processInputLine("move 60 65"))
    }
    "tell you when your input doesnt make sense" in {
      val result = tui.processInputLine("hello")
      result should be(tui.processInputLine("hello"))
    }
    // TODO tests

  }
}
