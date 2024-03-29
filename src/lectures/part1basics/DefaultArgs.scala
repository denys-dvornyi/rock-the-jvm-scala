package lectures.part1basics

object DefaultArgs extends App {

	def ttFact(n: Int, acc: Int = 1): Int = {
		if (n <= 1) acc
		else ttFact(n - 1, n * acc)
	}

	val fact10 = ttFact(10)
	println(fact10)

	def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")
	savePicture()
	savePicture("sd", 11)
	savePicture(width = 800)
	savePicture(height = 600, width = 800, format = "bmp")

	/*
		1. pass in every leading argument
		2. name the arguments
	*/

}
