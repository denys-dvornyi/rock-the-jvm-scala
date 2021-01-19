package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

	def factorialFunction(n: Int): Long = {
		if (n <= 1) 1
		else {
			println("Computing factorial of " + n + " I first need factorial of " + (n - 1))
			val result = n * factorialFunction(n - 1)
			println("Computed factorial of " + n + " is " + result)
			result
		}
	}

//	println(factorialFunction(50))

	def anotherFactorial(n: Int): BigInt = {
		@tailrec
		def factHelper(x: Int, accumulator: BigInt): BigInt = {
			if (x <= 1) accumulator
			else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the last expression
		}
		factHelper(n , 1)
	}

//	println(anotherFactorial(10_000))

	// WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION

	@tailrec
	def concatNtimes(string: String, c: Int, accumulator: String): String = {
		if (c <= 0) accumulator
		else concatNtimes(string, c - 1, accumulator + string)
	}

	println(concatNtimes("hello", 3, ""))

	def isPrimeNumber(n: Int): Boolean = {
		@tailrec
		def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
			if (!isStillPrime) false
			else if (t <= 1) true
			else isPrimeTailRec(t - 1, n % t != 0)
		}
		isPrimeTailRec(n / 2, true) // more optimized! test only half numbers
	}

	println("2003=" + isPrimeNumber(2003))
	println("2008=" + isPrimeNumber(2008))

	def fibonacciFunction(n: Int): Long = {
		@tailrec
		def fiboTailRec(c: Int, accumulator1: Long, accumulator2: Long): Long = {
			if (c == n - 2) accumulator1 + accumulator2
			else fiboTailRec(c + 1, accumulator2, accumulator2 + accumulator1)
		}
		if (n <= 2) 1
		else fiboTailRec(1, 1, 1)
	}

//	println("fibonacci from 1 = " + fibonacciFunction(1))
//	println("fibonacci from 2 = " + fibonacciFunction(2))
//	println("fibonacci from 3 = " + fibonacciFunction(3))
//	println("fibonacci from 4 = " + fibonacciFunction(4))
//	println("fibonacci from 5 = " + fibonacciFunction(5))
//	println("fibonacci from 6 = " + fibonacciFunction(6))
//	println("fibonacci from 7 = " + fibonacciFunction(7))
	println("fibonacci from 8 = " + fibonacciFunction(8))
//	println("fibonacci from 9 = " + fibonacciFunction(9))
	println("fibonacci from 10 = " + fibonacciFunction(10))

}
