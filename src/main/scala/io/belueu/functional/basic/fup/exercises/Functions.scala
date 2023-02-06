package io.belueu.functional.basic.fup.exercises

object Functions extends App {

  val doubler = new MyFunction[Int, Int] {
    override def apply(elem: Int): Int = elem * 2
  }

  println(doubler(2))

  val aStringToIntConverter = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(aStringToIntConverter("3") + 4)

  val adder: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  val stringConcatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(stringConcatenator("hello", "scala"))


  val superAdder = new Function1[Int, Function1[Int, Int]] {
    override def apply(first: Int): Int => Int = new Function[Int, Int] {
      override def apply(second: Int): Int = first + second
    }
  }

  val adder3 = superAdder(3)

  println(adder3(4))

}

trait MyFunction[A, B] {

  def apply(elem: A): B
}
