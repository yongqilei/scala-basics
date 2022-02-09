package com.torres.scala
package basics

import scala.annotation.tailrec

object DefaultArgs extends App {
  @tailrec
  def tailRecursive(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else tailRecursive(n - 1, acc * n)

  val fact10 = tailRecursive(4)
  println(fact10)

  def savePicture(format: String = "jpg", width: Int, height: Int): Unit = {
    println(s"Saving [$format] picture: width = $width, height = $height")
  }

  savePicture(width = 600, 600)
}
