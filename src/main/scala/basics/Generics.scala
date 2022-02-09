package com.torres.scala
package basics

object Generics extends App {

  class Animal

  class Dog extends Animal

  class Cat extends Animal

  // covariance
  class CovarianceList[+A]

  val animalList: CovarianceList[Animal] = new CovarianceList[Cat]

  // invariance
  class InvarianceList[A]

  val invariantAnimalList: InvarianceList[Animal] = new InvarianceList[Animal]

  // contravariance
  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded type
  class Cage[A <: Animal](animal: A) // equivalent with class Cage<A extends Animal> in Java

  val cage = new Cage(new Dog)

  class MyList[+A] {
    def add[B >: A](element: B): MyList[B] = ???
  }

}
