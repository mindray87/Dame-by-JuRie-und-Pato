package de.HTWG.se.Dame.model

import de.HTWG.se.Dame.model.enums.{Color, PieceType}

import scala.collection.mutable

case class Grid(val size: Int) {
  val field = Array.ofDim[Piece](size, size)

  override def toString: String = {
    val sb = new mutable.StringBuilder()
    for(i <- Range(0, field.length)){
      for(j <- Range(0, field.length)){
        sb.append("| ")
        val p = field(i)(j)
        if (p != null) {
          if (p.player == 1) {
            sb.append("O")
          } else {
            sb.append("X")
          }
        }else{
          sb.append(" ")
        }
        sb.append(" ")

      }
      sb.append("|\n")
    }
    return sb.toString()
  }

  def showGridNumbers: String = {
    val sb = new mutable.StringBuilder()
    for(i <- Range(0, field.length)){
      for(j <- Range(0, field.length)){
        sb.append("| ").append(i).append(j).append(" ")
      }
      sb.append("|\n")
    }
    return sb.toString()
  }

  def getCoordinates(p: Piece) : (Int, Int) = {
    for(i <- field){
      println(i.toString)
    }
    return (-1, -1)
  }

  def getPiece(x: Int, y : Int): Piece = {
    return field(x)(y)
  }
}

