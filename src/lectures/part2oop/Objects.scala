package lectures.part2oop

object Objects {

	// SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")

	// type + its only instance
	object Person { // objects DO NOT receive parameters
		// "static"/"class" - level functionality
		val N_EYES = 2
		def canFly: Boolean = false

		// factory method
		def from(mother: Person, father: Person): Person = new Person("Bobbie")

		def apply(mother: Person, father: Person): Person = new Person("Bobbie")
	}
	class Person(val name: String) {
		// instance-level functionality
	}
	// COMPANIONS

	println(Person.N_EYES)
	println(Person.canFly)

	// Scala object is SINGLETON instance
	val mary = new Person("Mary")
	val john = new Person("John")
	println(mary == john)

	val person1 = Person
	val person2 = Person
	println(person1 == person2)
//	val bobbie = Person.from(mary, john)
	val bobbie = Person(mary, john)

	// Scala Applications == Scala object with
	// def main(args: Array[String]): Unit
	def main(args: Array[String]): Unit = {

	}

}
