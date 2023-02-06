package io.belueu.functional.basic.fup

object MapFlatmapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  println(list.filter(_ % 2 == 0))

  println(list.flatMap(x => List(x + 2)))
  val toPair = (x: Int) => List(x, x + 2)
  println(list.flatMap(toPair))

  val list2 = List(4, 5, 6)
  println(list.flatMap(x => List(s"key:$x", list2)))

  // print all combinations between 2 lists
  val intList = List(1, 2, 3)
  val stringList = List("a", "b", "c")

  val combo = intList.flatMap(x => stringList.map(y => x + "" + y))
  val combo2 = intList.flatMap(a => list2.flatMap(b => stringList.map(c => a + "" + b + "" + c )))

  println(combo)
  println(combo2)

  list.foreach(println)

  val comboFor = for {
    ints <- intList
    strings <- stringList
  } yield ints + strings

  println(comboFor)

  val forCombo2 = for {
    ints1 <- intList if ints1 % 2 == 0
    ints2 <- list2 if ints2 % 2 == 0
    strings <- stringList
  } yield ints1 + "" + ints2 + strings
  println(forCombo2)

  val comboFiltered = intList.filter(_ % 2 == 0).flatMap(a => list2.filter(_ % 2 == 0).flatMap(b => stringList.map(c => a + "" + b + c)))
  println(comboFiltered)

  for {
    n <- list2
  } println(n)

  val doubledList = list2.map { x =>
    x * 2
  }
  println(doubledList)

  val oneElemList = List(1)
  println(oneElemList.head)
  println(oneElemList.tail)
}
