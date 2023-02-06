package io.belueu.functional.basic.fup.exercises

abstract class Maybe[+T] {
  def map[R](t: T => R): Maybe[R]
  def flatMap[R](t: T => Maybe[R]): Maybe[R]
  def filter(p: T => Boolean): Maybe[T]
}

case object MaybeNot extends Maybe[Nothing] {
  override def map[R](t: Nothing => R): Maybe[R] = MaybeNot
  override def flatMap[R](t: Nothing => Maybe[R]): Maybe[R] = MaybeNot
  override def filter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot
}

case class Just[+T](value: T) extends Maybe[T] {
  override def map[R](t: T => R): Maybe[R] = new Just[R](t(value))
  override def flatMap[R](t: T => Maybe[R]): Maybe[R] = t(value)
  override def filter(p: T => Boolean): Maybe[T] = {
    if (p(value)) this
    else MaybeNot
  }
}

object MaybeTest extends App {
  val just3 = Just(3)
  println(just3)
  println(just3.map(_ * 2))
  println(just3.flatMap(x => Just(x % 3 == 0)))
  println(just3.filter(_ % 2 == 0))
}


