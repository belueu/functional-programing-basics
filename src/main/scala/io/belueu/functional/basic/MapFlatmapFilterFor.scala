package io.belueu.functional.basic

object MapFlatmapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list.head)
  println(list.tail)

  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  println(list.filter(_ % 2 == 0))
  println(list.filter(_.toString.contains("3")))

  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")

  println(numbers.flatMap(n => chars.map(c => "" + c + n)))
  println(numbers.flatMap(n => chars.flatMap(c => colors.map(col => "" + c + "-" + n + "-" + col))))

  list.foreach(println)

  val forCombinations = for {
    n <- numbers
    c <- chars
    color <- colors
  } yield "" + c + "-" + n + "-" + color

  println(forCombinations)

  val forCombinationsFiltered = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + c + "-" + n + "-" + color

  println(forCombinationsFiltered)

  // The below line is equivalent to the above for-comprehension
  println(numbers.filter(_ % 2 == 0).flatMap(n => chars.flatMap(c => colors.map(color => "" + c + "-" + n + "-" + color))))

}
