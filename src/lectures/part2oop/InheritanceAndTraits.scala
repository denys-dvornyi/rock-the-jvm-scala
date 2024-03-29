package lectures.part2oop

object InheritanceAndTraits extends App {

	// single class inheritance
	sealed class Animal {
		val creatureType = "wild"
		final def eat = println("nomnom")
	}

	class Cat extends Animal {
		def crunch = {
			eat
			println("crunch crunch")
		}
	}

	val cat = new Cat
	cat.crunch

	// constructors
	class Person(name: String, age: Int) {
		def this(name: String) = this(name, 0)
	}
	class Adult(name: String, age: Int, idCard: String) extends Person(name)

	// overriding
	class Dog(override val creatureType: String) extends Animal {
//		override val creatureType = "domestic"
//		override def eat = println("crunch, crunch")
	}
	class Pig(pigType: String) extends Animal {
		override val creatureType: String = pigType;
	}

	val dog = new Dog("K9")
	dog.eat
	println(dog creatureType)

	// type substitution (broad: polymorphism)
	val unknownAnimal: Animal = new Dog("K9")
	unknownAnimal.eat

	// overRIDING vs overLOADING

	// super

	// preventing overrides
	// 1 - use final on member
	// 2 - use final on the entire class
	// 3 - seal the class = extend classes in THIS FILE, prevent extensions in other files
}
