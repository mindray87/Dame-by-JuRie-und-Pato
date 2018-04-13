package de.htwg.de.dame.model

case class Stone(){
  var isBlack = false
  var isDraught = false

  def toDraught(): Unit ={
    isDraught = true
  }
}
