package io.belueu.functional.basic.oop.exercises

object Examples extends App {

  // Function that takes a number and return all the numbers including the one specified as parameter

  println(TestObject4)
  println(TestObject4.simpleField)
  println(TestObject4.simpleField)

  println(TestObject4.noParameterMethod)
  println(TestObject4.noParameterMethod)

  assert(Calc3.square(2.0) == 4)
  assert(Calc3.square(3.0) == 9)
  assert(Calc3.square(-2.0) == 4)

}

object TestObject1 {
  def name: String = s"The best object ever"
}

object TestObject2 {
  def hello(name: String): String = {
    s"Hello $name"
  }
}

object TestObject3 {
  val name: String = "Noel"
  def hello(other: String): String = {
    s"$name say hi to $other"
  }
}

object TestObject4 {
  val simpleField = {
    println("Evaluating simpleField")
    42
  }

  def noParameterMethod = {
    println("Evaluating noParameterMethod")
    42
  }
}

object Oswald {
  val color = "Black"
  val food = "Milk"
}

object Henderson {
  val color = "Ginger"
  val food = "Chips"
}

object Quentin {
  val color = "Tabby and white"
  val food = "Curry"
}

object Calc {
  def square(p: Double): Double = {
    p * p
  }

  def cube(p: Double): Double = {
    square(p) * p
  }
}

object Calc2 {
  def square(p: Double) = {
    p * p
  }

  def square(p: Int) = {
    p * p
  }

  def cube(p: Double) = {
    square(p) * p
  }

  def cube(p: Int) = {
    square(p) * p
  }
}

object Person1 {
  val firstName = "John"
  val lastName = "Doe"
}

object Alien {
  def greet(p: Person1.type) = {
    s"Hello there human ${p.firstName}"
  }
}

object Calc3 {
  def square(input: Double): Double = {
    input * input
  }
}
