package lectures.part1basics

object CBNvsCBV extends App {

	def calledByValue(x: Long): Unit = {
		println("by value: " + x)
		println("by value: " + x)
	}

	def calledByName(x: => Long): Unit = {
		println("by value: " + x)
		println("by value: " + x)
	}

	calledByValue(System.nanoTime())
	calledByName(System.nanoTime())

	def infinite(): Int = 1 + infinite()
	def printFirst(x: Int, y: => Int) = println(x)

//	printFirst(infinite(), 34) // crash by StackOverflowError
	printFirst(34, infinite()) // do NOT crash! because evaluating of parameter by Name is delayed until in will be used

}
