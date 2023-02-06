package io.belueu.functional.basic.fup.exercises

object AnonFunctions extends App {

  val doubler: Int => Int = _ * 2

  println(doubler(3))

  val adder: (Int, Int) => Int = _ + _

  println(adder(3, 4))

  val justDoIt: () => String = () => "hello"

  println(justDoIt())

  val stringToInt = { str: String =>
    str.toInt
  }

  try {
    println(stringToInt("hello"))
  } catch {
    case exception: NumberFormatException => println(x = exception)
  } finally {
    println(0)
  }

  val niceIncrementer: Int => Int = _ + 1
  println(niceIncrementer(1))
  val niceAdder: (Int, Int) => Int = _ + _
  println(niceAdder(2,3))

  val superAdder: Int => Int => Int = (a: Int) => (b: Int) => a + b
  val add5 = superAdder(5)
  println(add5(3))
}
