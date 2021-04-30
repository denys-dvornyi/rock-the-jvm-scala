package exercises

abstract class MyList[+A] {
	def head: A
	def tail: MyList[A]
	def isEmpty: Boolean
	def add[B >: A](element: B): MyList[B]
	def printElements(): String
	// polymorphic call
	override def toString: String = "[" + printElements + "]"

	def map[B](transformer: MyTransformer[A, B]): MyList[B]
	def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
	def filter(predicate: MyPredicate[A]): MyList[A]

	// concatenation
	def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
	override def head:Nothing = throw new NoSuchElementException
	override def tail: MyList[Nothing] = throw new NoSuchElementException
	override def isEmpty: Boolean = true
	override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
	override def printElements: String = ""

	def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
	def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
	def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

	def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
	override def head: A = h
	override def tail: MyList[A] = t
	override def isEmpty: Boolean = false
	override def add[B >: A](element: B): MyList[B] = new Cons(element, this)
	override def printElements: String = {
		if (t.isEmpty) "" + h
		else h + " " + t.printElements()
	}

	def filter(predicate: MyPredicate[A]): MyList[A] =
		if (predicate.test(h)) new Cons(h, t.filter(predicate))
		else t.filter(predicate)

	def map[B](transformer: MyTransformer[A, B]): MyList[B] =
		new Cons(transformer.transform(h), t.map(transformer))

	def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
		transformer.transform(h) ++ t.flatMap(transformer)

	def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
}

trait MyPredicate[-T] {
	def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
	def transform(elem: A): B
}

object ListTest extends App {
	val listOfInt = new Cons(1, new Cons(2, new Cons(3, Empty)))
	val cloneListOfInt = new Cons(1, new Cons(2, new Cons(3, Empty)))
	val listOfInt2 = new Cons(4, new Cons(5, Empty))
	val listOfStrings = new Cons("Hello", new Cons(",", new Cons("World", Empty)))
	println(listOfInt)
	println(listOfStrings)
//	println(list.head)
//	println(list.tail.head)
//	println(list.add(4).head)
	println(listOfInt.map(new MyTransformer[Int, Int] {
		override def transform(elem: Int): Int = elem * 2
	}).toString)

	println(listOfInt.filter(new MyPredicate[Int] {
		override def test(elem: Int): Boolean = ((elem % 2) == 0)
	}).toString)

	println((listOfInt ++ listOfInt2).toString)

	println(listOfInt.flatMap(new MyTransformer[Int, MyList[Int]] {
		override def transform(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
	}).toString)

	println(listOfInt == cloneListOfInt)
}
