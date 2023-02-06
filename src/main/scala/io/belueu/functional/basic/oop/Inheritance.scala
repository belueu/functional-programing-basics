package io.belueu.functional.basic.oop

object Inheritance extends App {

  sealed class Animal {
    val creatureType = "wild"
    def eat(): Unit = println("Num..num..num")
  }

  class Cat extends Animal {
    def crunch(): Unit = {
      eat()
      println("Crunch...crunch")
    }
  }

  val cat = new Cat

  cat.crunch()

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age:Int, idCard: String) extends Person(name)

  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType: String = "domestic"
    override def eat(): Unit = super.eat() //println("Chao...chao")
  }

  val dog = new Dog("Husky")
  println(dog.creatureType)
  dog.eat()

  // type substitution
  val unknownAnimal: Animal = new Dog("Pitt bull")
  println(unknownAnimal.creatureType)
  unknownAnimal.eat()

}
