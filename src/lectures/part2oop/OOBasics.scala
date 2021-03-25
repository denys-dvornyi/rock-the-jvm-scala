package lectures.part2oop

object OOBasics extends App {

	val person = new Person("John", 26)
	println(person.age)
	person.greet("Daniel")
	person.greet
	val danBrown = new Writer("Dan", "Brown", 56)
	val shakespeare = new Writer("William", "Shakespeare", 33)
	println(shakespeare.fullname)
	val romeoAndJuliet = new Novel("Romeo and Juliet", 1597, shakespeare)
	println(romeoAndJuliet.authorAge)
	println(romeoAndJuliet.isWrittenBy(shakespeare))
	println(romeoAndJuliet.isWrittenBy(danBrown))
	val romeoAndJulietNewEdition = romeoAndJuliet.copy(2020)

	val counter = new Counter(3)
	counter.print
	counter.increment.print
	counter.increment.increment.increment.print
	counter.decrement.print

	counter.increment(2).print
	counter.decrement(2).print
}

class Counter(val counter: Int = 0) {
	def currentCount = counter

	def increment = new Counter(counter + 1) // immutability
	def decrement = new Counter(counter - 1)

	def increment(intBy: Int): Counter = {
		if (intBy <= 0) this
		else increment.increment(intBy - 1)
	}
	def decrement(decBy: Int): Counter = {
		if (decBy <= 0) this
		else decrement.decrement(decBy - 1)
	}
	def print = println(counter)
}

class Person(name: String, val age: Int) {
	// body
	val x = 2
	println(1 + 3)
	def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
	// overloading
	def greet: Unit = println(s"Hi, I am $name")

	def this(name: String) = this(name, 0)
	def this() = this("Garry")
	def this(age: Int) = this("Denis", age)
}

// class parameters are NOT FIELDS

class Writer(firstName: String, surname: String, val year: Int) {
	def fullname: String = s"$firstName $surname"
}

class Novel(name: String, year: Int, author: Writer) {
	def authorAge: Int = year - author.year
	def isWrittenBy(author: Writer): Boolean = author == this.author
	def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}
