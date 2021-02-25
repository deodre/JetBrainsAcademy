fun main() {
    val number: Int = readLine()!!.toInt()
    println(number - number % 2 + 2)
}