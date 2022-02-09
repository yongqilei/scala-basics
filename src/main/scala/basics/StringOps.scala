package com.torres.scala
package basics

object StringOps extends App {
  val str: String = "Hello I'm learning Scala"

  println(str.substring(6))

  val aNumberString = "2";
  println(aNumberString.toInt)
  // prepending +:
  // appending :+
  println('a' +: aNumberString :+ 'z')
}
