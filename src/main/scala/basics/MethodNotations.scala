package com.torres.scala
package basics

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = "What the heck?!"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
  }

  val mary = new Person("Mary", "John Wick")
  println(mary.likes("John Wick"))
  println(mary likes "John Wick") // infix notation or operator notation(used in single parameter) (syntactic sugar)

  // operators in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)

  // all operators are methods
  println(1 + 2)
  println(1.+(2))

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  println(x == y)

  println(!mary)

  // postfix notation (used by methods without parameters)
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent with apply method

}
