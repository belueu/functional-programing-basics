package io.belueu.functional.basic.oop

import scala.language.implicitConversions

object ADT extends App {

  val readPermission = PermissionType.getPermission(Read)
  println(s"Current permission: $readPermission")
  println(PermissionType.getPermissions)
}

sealed trait PermissionType extends Product
case object Read extends PermissionType
case object Write extends PermissionType
case object Delete extends PermissionType

object PermissionType {
  implicit def getPermission(permissionType: PermissionType): String = {
    permissionType match {
      case Read => "Read"
      case Write => "Write"
      case Delete => "Delete"
    }
  }
  implicit def getPermissions: String = {
    val permissionsList = List(Read, Write, Delete)
    permissionsList.mkString("All permissions: ", ", ", "")
  }
}

