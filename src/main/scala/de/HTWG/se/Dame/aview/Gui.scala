package de.HTWG.se.Dame.aview

import java.awt.Color

import de.HTWG.se.Dame.controller.controllerComponent._
import de.HTWG.se.Dame.model.enums.PieceType

import scala.swing.{Frame, Reactor, TextField, _}
import scala.swing.Swing.LineBorder
import scala.swing.event.{Event, Key}

class CellClicked(val row: Int, val column: Int) extends Event

class Gui(controller: Controller) extends Frame {

  listenTo(controller)

  title = "HTWG Dame"

  def gridPanel = new GridPanel(controller.getGridSize, controller.getGridSize) {
    border = LineBorder(java.awt.Color.BLACK, 2)
    background = java.awt.Color.BLACK

    var n = -1

    for (row <- controller.getGrid()) {
      n = n * -1
      for (_ <- row) {
        val l = new TextField("dasdas")

        l.horizontalAlignment = Alignment.Center
        l.preferredSize = new Dimension(50, 50)

        if (n == 1) {
          l.foreground = Color.WHITE
          l.background = Color.BLACK
        } else {
          l.foreground = Color.BLACK
          l.background = Color.WHITE
        }
        n = n * -1
        contents += l
      }
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
    case _: UpdateEvent => redraw
    case e: ErrorEvent => println(e.message)
    case e: PrintMovesEvent => println(controller.gridToString(e.position, e.moves))
  }

  visible = true


  private def redraw: Unit = {

    var i = 0

    for (row <- controller.getGrid()) {
      for (cell <- row) {

        val l : TextField = gridPanel.contents.apply(i).asInstanceOf[swing.TextField]

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
    this.repaint
    this.redraw
  }

}
