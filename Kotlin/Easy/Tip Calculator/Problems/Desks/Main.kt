fun main() {
    // put your code here
    val firstClass: Int = readLine()!!.toInt()
    val secondClass: Int = readLine()!!.toInt()
    val thirdClass: Int = readLine()!!.toInt()
    val totalStudents: Int = firstClass + secondClass + thirdClass
    println(firstClass / 2 + firstClass % 2 + secondClass / 2 + secondClass % 2 + thirdClass / 2 + thirdClass % 2)
}