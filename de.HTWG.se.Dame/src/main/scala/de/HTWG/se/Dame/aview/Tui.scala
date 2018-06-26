package de.HTWG.se.Dame.aview

import de.HTWG.se.Dame.controller.controllerComponent.{Controller, ErrorEvent, PrintMovesEvent, UpdateEvent}

import scala.swing.Reactor


class Tui(controller: Controller) extends Reactor {

  listenTo(controller)


  def processInputLine(input: String): Unit = {
    input match {
      case "info" =>
      case "q" => println("Goodbye")
      case _ =>
        val a = input.trim().split(" ")
        a match {

          case Array("move", coo1, coo2) =>
            controller.move(toIntTuple(coo1), toIntTuple(coo2))

          case Array("choose", c) =>
              controller.choosePiece(toIntTuple(c))


          case _ => println("Can't handle this.")
        }
    }
  }

  reactions += {
    case _ : UpdateEvent => printTui
    case e : ErrorEvent => println(e.message)
    case e : PrintMovesEvent => println(controller.gridToString(e.position, e.moves))
  }

  def printTui: Unit = {
    println(controller.gridToString())
  }

  def toIntTuple(s: String): (Int, Int) = {
    if (s.length != 2) {
      // Naja
      return (0, 0)
    }
    val arr = s.toCharArray
    return (Integer.valueOf(arr(0).asDigit), Integer.valueOf(arr(1).asDigit))
  }

}