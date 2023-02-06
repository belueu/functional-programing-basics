package io.belueu.functional.basic.oop

object Generics extends App {

  class MyList[+A] {
    // use the type A inside the class definition
    def add[B >: A](element: B): MyList[B] = ???
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyLitOfIntegers = MyList.empty[Int]

  // the variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // COVARIANCE = List[Cat] extends List[Animal]
  class CovariantList[+A]

  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  val animal: Animal = new Cat

  // INVARIANCE = List[Cat] extends List[Cat]
  class InvariantList[A]
  val invarianAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // CONTRAVARIANT
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  // upper bounded types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage[Dog](new Dog)

  class Car
//  val newCage = new Cage[Car](new Car)

  // lower bounded type
  class Soul[A >: Animal]
}
