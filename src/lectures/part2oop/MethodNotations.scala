package lectures.part2oop

object MethodNotations extends App {

	class Person(val name: String, favouriteMovie: String, val age: Int = 18) {
		def likes(movie: String): Boolean = movie == favouriteMovie
		def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
		def +(nick: String): Person = new Person(s"$name ($nick)", favouriteMovie)
		def unary_! : String = s"$name, what the heck?"
		def unary_+ : Person = new Person(name, favouriteMovie, age + 1)
		def isAlive: Boolean = true
		def learns(subject: String): String = s"$name learns $subject"
		def learnsScala: String = this.learns("Scala")
		def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
		def apply(n: Int): String = s"$name watched $favouriteMovie $n times"

		def print = println(s"My name is $name and my favourite movie is '$favouriteMovie', I'm $age years old")
	}

	val mary = new Person("Mary", "Inception")
	println(mary.likes("Inception"))
	println(mary likes "Inception") // equivalent
	// infix notation = operator notation

	val tom = new Person("Tom", "Fight Club")
	println(mary + tom)
	println(mary.+(tom))

	println(1 + 2)
	println(1.+(2))
	// ALL OPERATORS ARE METHODS !!

	// prefix notation
	val x = - 1 // equivalent with 1.unary_-
	val y = 1.unary_-
	// unary_ prefix only works with - + ~ !

	println(!mary)
	println(mary.unary_!)

	// postfix notation
	println(mary.isAlive)
	println(mary isAlive) // for methods with NO parameters

	// apply
	println(mary.apply())
	println(mary()) // equivalent (looks for apply method to run)

	println((mary + "the rockstar")())
	println((+mary).age)
	(+mary).print

	println(mary.learns("Java")) // == println(mary learns "Java") // ONLY for methods with ONE parameter!
	println(mary learnsScala)

	println(mary(2)) // == println(mary.apply(2))



}
