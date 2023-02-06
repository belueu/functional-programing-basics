package io.belueu.functional.basic.oop.exercises

object OOExercises extends App {

  val author = new Writer("Cristian", "Belu", 1986)
  val imposter = new Writer("Cristian", "Belu", 1986)
  val novel = new Novel("Functional Programing with Scala", 2022, author)

  println(novel.authorAge())
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))

  val counter: Counter = new Counter
  counter.increment().print()
  counter.increment().increment().increment().print()
  counter.increment(10).print()

}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge(): Int = yearOfRelease - author.yearOfBirth

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(newYearOfRelease: Int) = new Novel(name, newYearOfRelease, author)
}

class Writer(firstName: String, surname: String, val yearOfBirth: Int) {
  def fullName() = s"$firstName $surname"
}

class Counter(val count: Int = 0) {
  def increment(): Counter = {
    println("incrementing")
    new Counter(count + 1)
  }

  def decrement(): Counter = {
    println("decrementing")
    new Counter(count - 1)
  }

  def increment(amount: Int): Counter = {
    if (amount <= 0) this
    else increment().increment(amount - 1)
  }

  def decrement(amount: Int): Counter = {
    if (amount <= 0) this
    else decrement().decrement(amount - 1)
  }

  def print(): Unit = println(count)
}
