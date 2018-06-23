package de.HTWG.se.Dame.aview

import de.HTWG.se.Dame.controller.controllerComponent.{Controller, UpdateUI}

import scala.swing.Reactor


class Tui(controller: Controller) extends Reactor {

  listenTo(controller)


  def processInputLine(input: String): Unit = {
    var s = ""
    input match {
      case "show" => s = controller.showGrid()
      case "info" => s = controller.getMessage()
      case "q" => s = "Goodbye"
      case _ =>
        val a = input.trim().split(" ")
        a match {

          case Array("move", coo1, coo2) =>
            val src = toIntTuple(coo1)
            val dest = toIntTuple(coo2)
            controller.getPiece(src._1, src._2) match {
              case Some(p) => controller.move(dest._1, dest._2, p); s = "moved " + src + " -> " + dest
              case _ => s = "No piece at " + src + "."
            }

          case Array("choose", c) =>
            val src = toIntTuple(c)
            controller.getPiece(src) match {
              case Some(p) => s = controller.showGrid(src, controller.getPossibleMoves(p))
              case _ => s = "No piece at (" + src + ")."
            }

          case _ => println("Can't handle this.")
        }
    }
    println(s)
  }

  reactions += {
    case event: UpdateUI => printTui
  }

  def printTui: Unit = {
    println(controller.showGrid())
  }

  def toIntTuple(s: String): (Int, Int) = {
    if(s.length != 2){
      // Naja
      return (0,0)
    }
    val arr = s.toCharArray
    return (Integer.valueOf(arr(0).asDigit), Integer.valueOf(arr(1).asDigit))
  }

}