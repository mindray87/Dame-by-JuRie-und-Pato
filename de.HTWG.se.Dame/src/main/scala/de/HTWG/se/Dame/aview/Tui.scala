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
          case Array("move", row1, col1, row2, col2) => move((row1, col1), (row2, col2))
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

  private def move(from : (String, String), to : (String, String)): Unit ={
    val von = toInt(from)
    val nach = toInt(to)
    controller.move(nach._1, nach._2, controller.getPiece(von._1, von._2).get)
  }

  def toInt(s : (String, String)): (Int, Int) ={
    return (Integer.valueOf(s._1), Integer.valueOf(s._2))
  }

}