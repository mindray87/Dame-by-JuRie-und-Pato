package de.htwg.se.dame.aview

import de.htwg.se.dame.controller.controllerComponent.ControllerInterface
import de.htwg.se.dame.controller.controllerComponent.GameStatus
import de.htwg.se.dame.controller.controllerComponent.{CandidatesChanged, CellChanged, GridSizeChanged}

import scala.swing.Reactor

class Tui(controller: ControllerInterface) extends Reactor{

  listenTo(controller)
  def size = controller.gridSize

  def processInputLine(input: String):Unit = {
    input match {
      case "q" =>
      case "e" => controller.createEmptyGrid
      case "n" => controller.createNewGrid
      case "z" => controller.undo
      case "y" => controller.redo
      case "s" => controller.save
      case "l" => controller.load
      case "." => controller.resize(1)
      case "+" => controller.resize(4)
      case "#" => controller.resize(9)
      case _ => input.toList.filter(c => c != ' ').map(c => c.toString.toInt) match {
        case row :: col :: value :: Nil => controller.set(row, col, value)
        case row :: col::Nil => controller.showCandidates(row, col)
        case index::Nil => controller.highlight(index)
        case _ =>
      }

    }
  }

}
