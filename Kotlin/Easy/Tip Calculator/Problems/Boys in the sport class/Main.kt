fun main() {
    // put your code here
    val h1: Int = readLine()!!.toInt()
    val h2: Int = readLine()!!.toInt()
    val h3: Int = readLine()!!.toInt()
    println(h1 <= h2 && h2 <= h3 || h1 >= h2 && h2 >= h3)
}