package io.belueu.functional.basic.oop

object Enums extends Enumeration {
  type Enums = Value

  val READ, WRITE, DELETE = Value

}

object Enumeration extends App {
  val readPermission = Enums.READ
  println(readPermission.toString)
}
