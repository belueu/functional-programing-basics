package io.belueu.functional.basic.oop

object OOBasic extends App {

  val person = new Person("Cristi", 35)
  println(person.getName + " " + person.getAge)

  person.greet("Daniel")
  person.greet()

  val person2 = new Person("John")
  println(person2.getName + " " + person2.getAge)

  val person3 = new Person()
  println(person3.getName + " " + person3.getAge)

}

class Person(name: String, age: Int) {
  def getName: String = name
  def getAge: Int = age

  def greet(name: String): Unit = println(s"${this.name} says: Hi $name")

  def greet(): Unit = println(s"Hi, I am $name")

  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}