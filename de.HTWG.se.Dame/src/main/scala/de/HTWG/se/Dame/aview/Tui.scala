package de.HTWG.se.Dame.aview

import de.HTWG.se.Dame.controller.controllerComponent.{Controller, UpdateUI}

import scala.swing.Reactor


class Tui(controller: Controller) extends Reactor {

  listenTo(controller)

  def processInputLine(input: String): Unit = {
    input match {
      case "show" => println(controller.showGrid())
      case "info" => println(controller.getMessage())
      case "q" => println("Goodbye")
      case _ =>
        val a = input.split(" ")
        a match {
          case Array("move", row1, col1, row2, col2) => println(controller.move(Integer.valueOf(row2), Integer.valueOf(col2), controller.getPiece(Integer.valueOf(row1), Integer.valueOf(row1))))
          case Array("choose", row, col) => println(controller.getPossibleMoves(Integer.valueOf(row), Integer.valueOf(col)))
          case _ => println("Cann't handle this.")
        }
    }
  }

  reactions += {
    case event: UpdateUI => printTui
  }

  def printTui: Unit = {
    println(controller.showGrid())
  }


}