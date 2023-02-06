package io.belueu.functional.basic.oop.exercises

abstract class MyList[+A] {
  /*
  * head: Int = first element of the list
  * tail: List[Int] = remainder of the list
  * isEmpty = is this list empty
  * add(Int) => new list with this element added
  * toString => a string representation of the list
  * */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
  def map[B](t: A => B): MyList[B]
  def filter(p: A => Boolean): MyList[A]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def ++[B >: A](list: MyList[B]): MyList[B]

  // Hofs
  def foreach(f: A => Unit): Unit
  def sort(compare: (A, A) => Int): MyList[A]
  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]
  def fold[B](start: B)(operator: (B, A) => B): B
//  def foreach(f: A => Unit): Unit
//  def sort(compare: (A, A) => Int): MyList[A]
//  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]
//  def fold[B](start: B)(operator: (B, A) => B): B
}

case object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException
  override def tail: Nothing = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  override def printElements: String = ""
  override def map[B](t: Nothing => B): MyList[B] = Empty
  override def filter(p: Nothing => Boolean): MyList[Nothing] = Empty
  override def flatMap[B](t: Nothing => MyList[B]): MyList[B] = Empty
  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  // Hofs
  override def foreach(f: Nothing => Unit): Unit = ()
  override def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty
  override def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = {
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Empty
  }
  override def fold[B](start: B)(operator: (B, Nothing) => B): B = {
    start
  }
//  override def foreach(f: Nothing => Unit): Unit = ()
//  override def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty
//  override def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = {
//    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
//    else Empty
//  }
//  override def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h
  override def tail: MyList[A] = t
  override def isEmpty: Boolean = false
  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  override def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }
  override def map[B](transformer: A => B): MyList[B] = {
    new Cons[B](transformer(h), t.map(transformer))
  }
  override def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(h)) new Cons[A](h, t.filter(predicate))
    else t.filter(predicate)
  }
  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons[B](h, t ++ list)
  override def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  // Hofs
  override def foreach(f: A => Unit): Unit = {
    f(head)
    t.foreach(f)
  }
  override def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) Cons(x, sortedList)
      else Cons(sortedList.head, insert(x, sortedList.tail))
    }
    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }
  override def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Cons(zip(h, list.head), t.zipWith(list.tail, zip))
  }
  override def fold[B](start: B)(operator: (B, A) => B): B = {
    t.fold(operator(start, h))(operator)
  }
//  override def foreach(f: A => Unit): Unit = {
//    f(head)
//    t.foreach(f)
//  }
//
//  override def foreach(f: A => Unit): Unit = ???
//
//  override def sort(compare: (A, A) => Int): MyList[A] = {
//    def insert(x: A, sortedList: MyList[A]):MyList[A] = {
//      if (sortedList.isEmpty) new Cons[A](x, Empty)
//      else if (compare(x, sortedList.head) <= 0) new Cons[A](x, sortedList)
//      else new Cons[A](sortedList.head, insert(x, sortedList.tail))
//    }
//
//    val sortedTail = t.sort(compare)
//    insert(h, sortedTail)
//  }
//  override def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
//    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
//    else new Cons[C](zip(h, list.head), t.zipWith(list.tail, zip))
//  }
//  override def fold[B](start: B)(operator: (B, A) => B): B = {
//    t.fold(operator(start, h))(operator)
//  }
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, Empty)))
  val listOfIntegers2: MyList[Int] = new Cons[Int](4, new Cons[Int](5, Empty))
  val cloneListOfIntegers: MyList[Int] = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons[Int](4, new Cons[Int](5, Empty))
  val listOfStrings: MyList[String] = new Cons[String]("hello", new Cons[String]("dear", new Cons[String]("world", Empty)))
  val listOfStrings2: MyList[String] = new Cons[String]("hello", new Cons[String]("scala", Empty))

  println(listOfIntegers.map(_ * 3).toString)
  println(listOfStrings.filter(n => n.contains("e")).toString)
  println(listOfIntegers.filter(_ % 2 == 0).toString)
  println((listOfIntegers ++ anotherListOfIntegers).toString)
  println(listOfIntegers.flatMap(elem => new Cons[Int](elem, new Cons[Int](elem + 1, Empty))).toString)

  println(cloneListOfIntegers == listOfIntegers)

  listOfIntegers.foreach(println)
  listOfStrings.foreach(println)

  println(listOfIntegers.sort((x, y) => y - x))
  println(listOfStrings.sort((x, y) => y.compareTo(x)))

  println(listOfStrings2.zipWith(listOfIntegers2, (x: String, y: Int) => x + ":" + y).sort((x, y) => y.compareTo(x)))
  println(listOfIntegers.zipWith[String, String](listOfStrings, _ + "-" +  _ ))

  println(listOfIntegers.fold(0)((x: Int, y: Int) => x + y))
  println(listOfStrings2.fold("_")((x: String, y: String) => x + y))
  //  println(listOfIntegers.fold[Int](3)(_ + _))

  val doubledListValues = for {
    n <- listOfIntegers
  } yield n * 2

  println(doubledListValues)
}
