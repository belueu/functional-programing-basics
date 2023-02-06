package io.belueu.functional.basic.oop

object Objects extends App {

  object Person {
    val N_EYES: Int = 2

    def canFly: Boolean = false

    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
  }
  // COMPANIONS Design Pattern


    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object is a Singleton instance
    val mary = new Person("Mary")
    val tom = new Person("Tom")
    println(mary == tom)

    val bobbie = Person(mary, tom)

    val person1 = Person
    val person2 = Person
    println(person1 == person2)
    println(bobbie.name)
    // Scala Applications = Scala object with
    // def main(args: Array[String]): Unit = {}
}
