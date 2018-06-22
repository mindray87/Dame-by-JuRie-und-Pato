package de.HTWG.se.Dame.aview

import de.HTWG.se.Dame.controller.controllerComponent.{Controller, UpdateTui}

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
          case Array("move", row1, col1, row2, col2) => controller.move(Integer.valueOf(row2), Integer.valueOf(col2), controller.grid.getPiece(Integer.valueOf(row1), Integer.valueOf(row2)))
          case Array("choose", row, col) => controller.getPossibleMoves(Integer.valueOf(row), Integer.valueOf(col))
          case _ => println("Cann't handle this.")
        }
    }
  }

  reactions += {
    case event: UpdateTui => printTui
  }

  def printTui: Unit = {
    println("It's working.")
  }


}