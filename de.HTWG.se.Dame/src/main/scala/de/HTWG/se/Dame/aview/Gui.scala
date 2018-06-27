package de.HTWG.se.Dame.aview

import java.awt.Color

import de.HTWG.se.Dame.controller.controllerComponent._
import de.HTWG.se.Dame.model.enums.PieceType

import scala.swing.{Frame, Reactor, TextField, _}
import scala.swing.Swing.EmptyBorder
import scala.swing.event.{Event, Key, MouseClicked}

class CellClicked(val row: Int, val column: Int) extends Event

class Gui(controller: Controller) extends Frame {

  listenTo(controller)

  title = "HTWG Dame"

  val gridPanel = new GridPanel(controller.getGridSize, controller.getGridSize) {
    border = EmptyBorder(0)
    background = java.awt.Color.BLACK

    var n = -1
    var x = 0
    var y = 0
    for (row <- controller.getGrid()) {
      n = n * -1
      for (cell <- row) {
        val l = new TextField()
        l.border = EmptyBorder(0)
        l.horizontalAlignment = Alignment.Center
        l.preferredSize = new Dimension(50, 50)
        l.editable = false
        l.listenTo(l.mouse.clicks)
        l.name = "" + x + y
        println("name = " + l.name)
        l.reactions += {
          case e: MouseClicked =>
            choose(e.source.asInstanceOf[TextField])
        }
        if (n == 1) {
          l.foreground = Color.WHITE
          l.background = Color.BLACK
        } else {
          l.foreground = Color.BLACK
          l.background = Color.WHITE
        }
        n = n * -1
        contents += l
        y += 1
      }
      x += 1
      y = 0
    }
  }

  val statusline = new TextField(controller.getMessage, 20)
  statusline.editable = false

  contents = new BorderPanel {
    add(menuBar, BorderPanel.Position.North)
    add(gridPanel, BorderPanel.Position.Center)
    add(statusline, BorderPanel.Position.South)
  }

  menuBar = new MenuBar {
    contents += new Menu("File") {
      mnemonic = Key.F
      contents += new MenuItem(Action("New") {})
      contents += new MenuItem(Action("Save") {
        controller.save
      })
      contents += new MenuItem(Action("Load") {
        controller.load
      })
      contents += new MenuItem(Action("Quit") {
        System.exit(0)
      })
    }
    contents += new Menu("Edit") {
      mnemonic = Key.E
      contents += new MenuItem(Action("Undo") {
        controller.undo
      })
      contents += new MenuItem(Action("Redo") {
        controller.redo
      })
    }

  }

  reactions += {
    case _: UpdateEvent => updateGUI
    case e: ErrorEvent => println(e.message)
    case e: PrintMovesEvent => displayMoves(e.position, e.moves)
  }

  visible = true

  def choose(tf: TextField) : Unit = {
    val name = tf.name
    val tu = (name(0).asDigit.toInt, name(1).asDigit.toInt)
    println("pressed: " + tu)
    controller.choosePiece(tu)
  }

  def displayMoves(position : (Int, Int), moves : List[(Int, Int)]): Unit ={
    for (a <- gridPanel.contents){
      if(a.name(0).asDigit.toInt == position._1 && a.name(1).asDigit.toInt == position._2)
        a.background = Color.yellow
    }
  }

  private def updateGUI: Unit = {
    var i = 0
    for (row <- controller.getGrid()) {
      for (cell <- row) {

        val l = gridPanel.contents.apply(i).asInstanceOf[swing.TextField]

        cell match {
          case Some(p) =>
            if (p.player == 1 && p.pieceType == PieceType.Men) {
              l.text = "O"
              l.text_=("o")
            } else if (p.player == 1 && p.pieceType == PieceType.King) {
              l.text = "DO"
            } else if (p.player == 2 && p.pieceType == PieceType.Men) {
              l.text = "X"
            } else if (p.player == 2 && p.pieceType == PieceType.King) {
              l.text = "DX"
            }
          case None =>
        }

        i += 1
      }
    }
    repaint()
  }

}

class ClickEvent extends Event(){

}
