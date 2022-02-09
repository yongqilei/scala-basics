package com.torres.scala
package basics

import scala.language.postfixOps

object MethodNotationsEx extends App {

  val mary = new Person("Mary", "Fight Club", 28)
  println(s"My name is ${mary.name} and I am ${mary.age} years old.")
  val newMary = mary + "the rockstar"
  println(newMary.name)
  val plusAge = +mary
  println(s"new age is ${plusAge.age}")

  println(mary learnsScala)
  println(mary(2))
}

class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
  def +(postfix: String): Person = new Person(s"$name ($postfix)", favoriteMovie, age)
  def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
  def learns(course: String): String = s"${this.name} learns $course"
  def learnsScala: String = this learns "Scala"
  def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
}
