package io.belueu.functional.basic.fup

object AnonymousFunctions extends App {

  // Anonymous function (LAMBDA)
  val doubler: Int => Int = _ * 2

  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  val justDoIt: () => Int = () => 42

  println(justDoIt)
  println(justDoIt())

  val stringToInt: String => Int = { (str: String) =>
    str.toInt
  }

  def stringsToInteger: String => List[Int] = {
    str: String => List(str.toInt)
  }

  val niceIncrementer: Int => Int = _ + 1
  val niceAdder: (Int, Int) => Int = _ + _
  val niceAdder2 = (a: Int, b: Int) => a + b

  val myList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val myStringList = List("1", "2", "3")

  println(niceIncrementer(3))
  println(niceAdder2(2, 3))
  println(niceAdder(3, 4))
  println(myList.map((elem: Int) => List[Int] {
    if (elem % 3 == 0) elem * 3
    else elem * 2
  }).flatMap((list: List[Int]) => List[List[Int]] {
    list.map({
      x: Int => x * 2
    })
  }).flatMap((elem: List[Int]) => List[Int] {
    elem.head
  }))

  println(myStringList.flatMap((elem: String) => List[Int] {
    stringToInt(elem)
  }))

  println(stringsToInteger("22"))

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))

  val sayHello = (name: String, age: Int) => s"Hi, my name is $name, and I am $age years old. Nice to meet you"

  def sayHi: (String, String) => String = {
    (name: String, age: String) => s"Hi, I'm $name of age $age"
  }

  println(sayHello("Cristi", 25))

  println(sayHi("Cristi", "22"))

  def mySpecialMethod(v1: String, v2: String, v3: String): String => String => String = {
    (value1: String) => (value2: String) => v1 + value1 + value2 + v2 + value1 + value2 + v3

  }

  println(mySpecialMethod("a", "b", "c")("hehe")("hibi"))

  val doublerFunction: Int => Int = _ * 2

  println(doublerFunction(2))
}
