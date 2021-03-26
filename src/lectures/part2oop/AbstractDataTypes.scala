package lectures.part2oop

object AbstractDataTypes extends App {

	// abstract class can't be instantiated
	abstract class Animal(cType: String = "wild") {
		val creatureType: String = cType
		def eat: Unit
	}

	class Dog extends Animal("domestic") {
		override val creatureType: String = "Canine"
		override def eat: Unit = println("crunch crunch")
	}

	// traits
	trait Carnivore { // плотоядное
		val preferredMeal: String = "fresh meat"
		def eat(animal: Animal): Unit
	}
	trait ColdBlooded

	class Crocodile extends Animal with Carnivore with ColdBlooded {
		override val creatureType: String = "croc"
		override def eat: Unit = "nomnomnom"
		override def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
	}

	val dog = new Dog
	val crocodile = new Crocodile
	crocodile.eat(dog)

	// traits vs abstract classes
	// 1 - traits do not have constructor parameters
	// 2 - multiple traits may be inherited by the same class
	// 3 - traits == "behavior", abstract class == "thing"

}
