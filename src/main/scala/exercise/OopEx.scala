package com.torres.scala
package exercise

trait MyList[+A] {
  def head: A
  def next: MyList[A]
  def add[B >: A](b: B): MyList[B]
  def isEmpty: Boolean
  def printElements: String
  override def toString: String = s"${this.getClass.getCanonicalName}[$printElements]"
  def filter(predicate: MyPredicate[A]): MyList[A]
  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def next: MyList[Nothing] = throw new NoSuchElementException
  def add[B >: Nothing](b: B): MyList[B] = new Cons[B](b, Empty)
  def isEmpty: Boolean = true
  def printElements: String = ""
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
}

class Cons[+A](a: A, n: MyList[A]) extends MyList[A] {
  def head: A = a
  def next: MyList[A] = n
  def add[B >: A](b: B): MyList[B] = {
    if (isEmpty) new Cons[B](b, Empty)
    else new Cons[B](head, n.add(b))
  }
  override def isEmpty: Boolean = false
  def printElements: String = {
    if (isEmpty) s"$a"
    else s"$a ${n.printElements}"
  }
  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(head)) new Cons(a, n.filter(predicate))
    else n.filter(predicate)
  }
  def map[B](transformer: MyTransformer[A, B]): MyList[B] = new Cons[B](transformer.transform(a), n.map(transformer))
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = ???
}


trait MyPredicate[-T] {
  def test(t: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(a: A): B
}


object MyListTest extends App {
  val listOfIntegers = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, Empty)))
  println(listOfIntegers.add(4).toString)
  println(listOfIntegers.map((a: Int) => a * 2).toString)
}