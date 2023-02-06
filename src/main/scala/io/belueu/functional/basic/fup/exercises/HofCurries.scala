package io.belueu.functional.basic.fup.exercises

import scala.annotation.tailrec

object HofCurries extends App {

//  val superFunction: (Int, (String, Int => Boolean) => Int) => Int => Int = ???

  @tailrec
  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n - 1 , f(x))
  }

  val plus1: Int => Int = _ + 1
  println(nTimes(plus1, 10, 20))

  def nTimesBetter(f: Int => Int, n: Int): Int => Int = {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))
  }

  val increment10 = nTimesBetter(plus1, 10)
  println(increment10(10))

  def toCurry[A, B, C](f: (A, B) => C): A => B => C = {
    (x: A) => (y: B) => f(x, y)
  }

  def fromCurry[A, B, C](f: A => B => C): (A, B) => C = {
    (x: A, y: B) => f(x)(y)
  }

  def compose[A, B, C](f: A => B, g: C => A): C => B = {
    x: C => f(g(x))
  }

  def andThen[A, B, C](f: A => B, g: B => C): A => C = {
    x: A => g(f(x))
  }

  def specialAdder: Int => Int => Int = toCurry(_ + _)
  def add3: Int => Int = specialAdder(3)
  println(add3(12))

  val specialCurryAdder: Int => Int => Int = (a: Int) => (b: Int) => a + b

  val simpleAdder = fromCurry(specialCurryAdder)
  println(simpleAdder(11, 31))

  val add2 = (x: Int) => x + 2
  val times3 = (x: Int) => x * 3

  val composed = compose(add2, times3)
  val ordered = andThen(add2, times3)

  println(composed(3))
  println(ordered(3))
}
