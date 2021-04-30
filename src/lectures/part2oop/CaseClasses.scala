package lectures.part2oop

object CaseClasses extends App {

	case class Person(name: String, age: Int)

	// 1. class parameters are fields
	val jim = new Person("Jim", 34)
	println(jim.name)

	// 2. sensible toString
//	println(jim) // println(instance) == println(instance.toString)
	println(jim.toString)

	// 3. equals and hash implemented OOTB 'Out Of The Box'
	val jim2 = new Person("Jim", 34)
	println(jim == jim2)

	// 4. CCs have handy copy method
	val jim3 = jim.copy(age = 45, name = "John")
	println(jim3)

	// 5. CCs have companion objects
	val thePerson = Person
	val mary = Person("Mary", 23)

	// 6. CCS are serializable
	// Akka

	// 7. CCS have extractor patterns = CCs can be used in PATTERN MATCHING

	case object UnitedKingdom {
		def name: String = "The UK of GB and NI"
	}
}
