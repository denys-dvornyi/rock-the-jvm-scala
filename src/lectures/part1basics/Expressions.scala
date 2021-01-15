package lectures.part1basics

object Expressions extends App {

	val x = 1 + 2 // expression
	println(x)

	println(2 + 3 * 4) // math expression
	// + - * / & | ^ << >> >>>(right shift with zero extension)

	println(1 == x) // relational operations
	// == != > >= < <=

	println(!(1 == x)) // logical operations
	// ! && ||

	var aVariable = 2
	aVariable += 3 // alse works with -+ *= ?=  ........  side effects
	println(aVariable)

	// Instructions (DO) vs Expressions (VALUE)

	// IF expression
	val aCondition = true
	val aConditionedValue = if (aCondition) 6 else 3 // IF Expression
	println(aConditionedValue)
	println(if (aCondition) 7 else 5)

	var i = 0
	val aWhile = while (i < 10) {
		println(i)
		i += 1
	}

	// NEVER WRITE THIS AGAIN

	// EVERYTHING in Scala is an Expression!

	val aWeirdValue = (aVariable = 3) // Unit === void
	println(aWeirdValue)

	// side effects: println(), whiles, reassigning

	// Code blocks

	val aCodeBlock = {
		val y = 2
		val z = 1 + 1
		if (z > 2) "hello" else "goodbye"
	}
	
}
