package de.HTWG.se.Dame.aview

import java.awt.Color

import de.HTWG.se.Dame.controller.controllerComponent._
import de.HTWG.se.Dame.model.enums.{PieceType}

import scala.swing.{Frame, Reactor, TextField, _}
import scala.swing.Swing.EmptyBorder
import scala.swing.event.{Event, Key, MouseClicked}

class CellClicked(val row: Int, val column: Int) extends Event

class Gui(controller: Controller) extends Frame {

  listenTo(controller)
  title = "HTWG Dame"

  var choosed: Option[(Int, Int)] = None
  var moves: List[(Int, Int)] = Nil

  val gridPanel = new GridPanel(controller.getGridSize, controller.getGridSize) {
    border = EmptyBorder(0)
    background = java.awt.Color.BLACK

    var n = -1
    var x = 0
    var y = 0
    for (row <- controller.getGrid()) {
      n = n * -1
      for (_ <- row) {
        val l = new TextField()
        l.border = EmptyBorder(0)
        l.horizontalAlignment = Alignment.Center
        l.preferredSize = new Dimension(50, 50)
        l.editable = false
        l.listenTo(l.mouse.clicks)
        l.name = "" + x + y
        l.reactions += {
          case e: MouseClicked =>
            clicked(e.source.asInstanceOf[TextField])
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

  def handleError(message: String): Unit = {
    resetTiles
    statusline.text_=(message)
  }

  reactions += {
    case _: UpdateEvent => updateGUI
    case e: ErrorEvent => handleError(e.message)
    case e: PrintMovesEvent => displayMoves(e.position, e.moves)
  }

  visible = true

  def clicked(tf: TextField): Unit = {
    val name = tf.name
    val tuple = (name(0).asDigit.toInt, name(1).asDigit.toInt)

    choosed match {
      case Some(c) =>
        if (moves.contains(tuple)) {
          controller.move(c, tuple)
        } else
          controller.choosePiece(tuple)

      case None =>
        controller.choosePiece(tuple)
    }
  }

  def displayMoves(position: (Int, Int), moves: List[(Int, Int)]): Unit = {
    resetTiles
    this.moves = moves
    this.choosed = Some(position)
    for (a <- gridPanel.contents) {
      val b = (a.name(0).asDigit.toInt, a.name(1).asDigit.toInt)
      if (b == position)
        a.background = Color.GRAY
      else
        for (p <- moves) {
          if (b == p) {
            a.background = Color.DARK_GRAY
          }
        }
    }
  }

  def resetTiles: Unit = {
    var i = 1
    var n = 0
    for (_ <- 0 to controller.getGridSize - 1) {
      for (_ <- 0 to controller.getGridSize - 1) {
        if (i == 1) {
          gridPanel.contents(n).background = Color.BLACK
        } else {
          gridPanel.contents(n).background = Color.WHITE
        }
        n += 1
        i *= -1
      }
      i *= -1
    }
  }

  private def updateGUI: Unit = {
    choosed = None
    moves = Nil
    var i = 0
    for (row <- controller.getGrid()) {
      for (cell <- row) {

        val txtField = gridPanel.contents.apply(i).asInstanceOf[swing.TextField]

        cell match {
          case Some(p) =>
            if (p.player == 1 && p.pieceType == PieceType.Men) {
              txtField.text = "O"
            } else if (p.player == 1 && p.pieceType == PieceType.King) {
              txtField.text = "DO"
            } else if (p.player == 2 && p.pieceType == PieceType.Men) {
              txtField.text = "X"
            } else if (p.player == 2 && p.pieceType == PieceType.King) {
              txtField.text = "DX"
            }
          case None => txtField.text = ""
        }

        i += 1
      }
    }
    repaint()
    resetTiles
  }
}