package io.belueu.functional.basic.oop

object AbstractDataTypes extends App {

  abstract class Animal {
    val creatureType: String = "wild"
    protected def eat(): Unit = println("Eat method from the super class")
  }

  class Dog extends Animal {
    override val creatureType: String = "Husky"
    override def eat(): Unit = println("Chao...chao")
  }

  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {

    override val creatureType: String = "Salt watter crocodile"
    override def eat(): Unit = println("Crash...crash")
    override def eat(animal: Animal): Unit = println(s"Crocodile eats ${animal.creatureType}")
  }

  val dog = new Dog
  val crocodile = new Crocodile

  crocodile.eat(dog)
  println(crocodile.preferredMeal)
  crocodile.eat()
}
