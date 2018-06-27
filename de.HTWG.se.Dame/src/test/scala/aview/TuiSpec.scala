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
    // TODO tests

  }
}
