package io.belueu.functional.basic.fup

object WhatsAFunction extends App {


  val doubler = new MyFunction[Int, Int] {
    override def apply(n: Int): Int = n * 2
  }

  println(doubler(2))

  // function types = Function[A, B]

  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("42"))

  val adder: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // Function types Function2[A, B, R] => (A, B) => R

  // All Scala functions are objects

  // 1. Define a function which takes 2 Strings and concatenates them
  // 2. Transform the MyPredicate and MyTransformer into function types
  // 3. Define a function which takes an Int and return another function which takes an Int and returns an Int

  def concatenate: (String, String) => String = new Function2[String, String, String] {
    override def apply(s1: String, s2: String): String = s1 + s2
  }
  println(concatenate("Hello ", "world"))

  def superAdder: Int => Int => Int = new Function[Int, Int => Int] {
    override def apply(n: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(m: Int): Int = n + m
    }
  }

  println(superAdder(3)(4)) // curried function
}

trait MyFunction[A, B] {
  def apply(n: A): B
}