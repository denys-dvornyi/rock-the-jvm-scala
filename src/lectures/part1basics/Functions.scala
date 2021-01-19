package lectures.part1basics

object Functions extends App {

	def aFunction(a: String, b: Int): String = {
		a + " " + b
	}

	println(aFunction("hello", 3))

	def aParameterLessFunction(): Int = 42

	println(aParameterLessFunction())
	println(aParameterLessFunction)

	def aRepeatedFunction(aString: String, n: Int): String = {
		if (n == 1) aString
		else aString + aRepeatedFunction(aString, n - 1)
	}

	println(aRepeatedFunction("hello", 3))
	// WHEN YOU NEED LOOPS, USE RECURSION.

	def aFunctionWithSideEffects(aString: String): Unit = println(aString)

	def aBigFunction(n: Int): Int = {
		def aSmallerFunction(a: Int, b: Int): Int = a + b
		aSmallerFunction(n, n - 1)
	}

	def greetingFunction(name: String, age: Int): Unit = {
		println("Hi, my name is " + name + " and I am " + age + " years old.")
	}

	greetingFunction("Den", 37)

	def factorialFunction(n: Int): Long = {
		if (n <= 1) 1
		else n * factorialFunction(n - 1)
	}

	println(factorialFunction(5))

	def fibonacciFunction(n: Int): Long = {
		if (n <= 2) 1
		else fibonacciFunction(n - 1) + fibonacciFunction(n - 2)
	}

	println("fibonacci from 7 = " + fibonacciFunction(7))

	def isPrimeNumber(n: Int): Boolean = {
		def isPrime(t: Int): Boolean = {
			if (t <= 1) true
			else n % t != 0 && isPrime(t - 1)
		}
		isPrime(n / 2) // more optimized! test only half numbers
	}

	println(" 1=" + isPrimeNumber( 1))
	println(" 2=" + isPrimeNumber( 2))
	println(" 3=" + isPrimeNumber( 3))
	println(" 4=" + isPrimeNumber( 4))
	println(" 5=" + isPrimeNumber( 5))
	println(" 6=" + isPrimeNumber( 6))
	println(" 7=" + isPrimeNumber( 7))
	println(" 8=" + isPrimeNumber( 8))
	println(" 9=" + isPrimeNumber( 9))
	println("10=" + isPrimeNumber(10))
	println("11=" + isPrimeNumber(11))
	println("12=" + isPrimeNumber(12))
	println("13=" + isPrimeNumber(13))
	println("37=" + isPrimeNumber(37))
	println("38=" + isPrimeNumber(38))
	println("2003=" + isPrimeNumber(2003))
	println("2008=" + isPrimeNumber(2008))
	println("5 * 7=" + isPrimeNumber(5 * 7))

}
