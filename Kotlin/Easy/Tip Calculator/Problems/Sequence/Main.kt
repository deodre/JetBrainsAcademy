fun main() {
    // put your code here
    val first: Char = readLine()!!.first()
    val second: Char = readLine()!!.first()
    val third: Char = readLine()!!.first()
    println(first == second - 1 && second == third - 1)
}