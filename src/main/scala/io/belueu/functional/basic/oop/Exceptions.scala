package io.belueu.functional.basic.oop

object Exceptions extends App {

  val x: String = null

  //  val anException: String = throw new NullPointerException()

  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42
  }

  val potentialFail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => println(e.getMessage)
  } finally {
    println("Finally")
  }

  //  println(x.length)
  println(potentialFail)

  class MyException extends Exception
  val exception = new MyException

  //  throw exception

  //  val array = Array.ofDim(Int.MaxValue)
  //    def infinite: Int = 1 + infinite
  //    val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y:Int): Int = {
      val result = x - y

      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

//  println(PocketCalculator.divide(10, 0))
  println(PocketCalculator.divide(10, 2))

}
