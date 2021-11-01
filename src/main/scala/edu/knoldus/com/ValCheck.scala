package edu.knoldus.com

  case class ValCheck(value: Double) extends Ordered[ValCheck] {
    def compare(that: ValCheck): Int =
      if (this.value < that.value) -1
      else if (this.value > that.value) 1
      else 0
  }

