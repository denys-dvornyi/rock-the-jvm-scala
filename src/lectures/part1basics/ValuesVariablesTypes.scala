package lectures.part1basics

object ValuesVariablesTypes extends App {

	val x: Int = 42 // VALs are immutable!
	// x = 2 error
	println(x)
	val y = 13
	// compiler can infer (делать вывод) types
	println(y)

	val aString: String = "hello"

	val eBoolean: Boolean = true
	val aChar: Char = 'a'
	val anInt: Int = x
	val aShor: Short = 32_767 // half int (max value < 32768)
	val aLong: Long = 9_223_372_036_854_775_807L
	val aFloat: Float = 2.0f
	val aDouble: Double = 3.14

	var aVariable: Int = 4
	aVariable = 5 // side effects
	var test = "test"

	println(test)

}
