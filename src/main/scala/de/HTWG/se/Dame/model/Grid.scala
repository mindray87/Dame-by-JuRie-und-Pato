package de.HTWG.se.Dame.model

import de.HTWG.se.Dame.model.enums.{Color, PieceType}

import scala.collection.mutable

case class Grid(val size: Int) {
  val field = Array.fill[Option[Piece]](size, size)(None)

  override def toString: String = {
    val sb = new mutable.StringBuilder(" ")
    for (a <- Range(0, field.length)) sb.append("   ").append(a).append("  ")
    sb.append("\n")
    for (x <- Range(0, field.length)) {
      sb.append(x)
      for (y <- Range(0, field.length)) {
        sb.append("| ")
        field(x)(y) match {
          case Some(p) =>
            if (p.player == 1) {
              if (p.t == PieceType.King)
                sb.append(" DO")
              else
                sb.append(" O ")
            } else {
              if (p.t == PieceType.King)
                sb.append(" DX")
              else
                sb.append(" X ")
            }
          case None =>
            sb.append("   ")
        }
        sb.append(" ")
      }
      sb.append("|\n")
    }
    return sb.toString()
  }


  def toString(c: (Int, Int), list: List[(Int, Int)]): String = {
    val sb = new mutable.StringBuilder(" ")
    for (a <- Range(0, field.length)) sb.append("   ").append(a).append("  ")
    sb.append("\n")
    for (x <- Range(0, field.length)) {
      sb.append(x)
      for (y <- Range(0, field.length)) {
        sb.append("| ")
        field(x)(y) match {
          case Some(p) =>
            if ((x, y) == c) {
              sb.append(" # ")
            }
            else if (p.player == 1) {
              if (p.t == PieceType.King)
                sb.append(" DO")
              else
                sb.append(" O ")
            } else {
              if (p.t == PieceType.King)
                sb.append(" DX")
              else
                sb.append(" X ")
            }
          case None =>
            if (list.contains((x, y))) {
              sb.append(" ").append(x).append(y)
            } else {
              sb.append("   ")
            }
        }
        sb.append(" ")
      }
      sb.append("|\n")
    }
    return sb.toString()
  }

  def showGridNumbers: String = {
    val sb = new mutable.StringBuilder()
    for (i <- Range(0, field.length)) {
      for (j <- Range(0, field.length)) {
        sb.append("| ").append(i).append(j).append(" ")
      }
      sb.append("|\n")
    }
    return sb.toString()
  }

  def getCoordinates(p: Piece): Option[(Int, Int)] = {
    var x = 0
    for (row <- field) {
      var y = 0
      for (cell <- row) {
        if (cell != None && (cell.get eq p)) {
          return Some((x, y))
        }
        y += 1
      }
      x += 1
    }
    return None
  }

  def getPiece(n: (Int, Int)): Option[Piece] = {
    if (!outOfBounds(n) && field(n._1)(n._2) != None) {
      return field(n._1)(n._2)
    } else {
      return None
    }
  }

  def outOfBounds(c: (Int, Int)): Boolean = {
    if (c._1 < 0) return true
    if (c._1 >= field.length) return true
    if (c._2 < 0) return true
    if (c._2 >= field.length) return true
    return false
  }
}

