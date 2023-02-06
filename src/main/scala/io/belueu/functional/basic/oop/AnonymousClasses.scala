package io.belueu.functional.basic.oop

object AnonymousClasses extends App {

  trait Animal {
    def eat(): Unit = println("Hello from trait animal")
  }

  val funnyAnimal: Animal = new Animal {}
  funnyAnimal.eat()

  class Person(name: String) {
    def sayHi(): String = s"Hi my name is $name and I'm saying hi to you!"
  }

  val jim = new Person("Jim") {
    override def sayHi(): String = s"Hi again, I'm Marko, do you need my help?"
  }
  println(jim.sayHi())

  val person = new Person("Gianni")
  println(person.sayHi())
}
