fun main() {
    // put your code here
    val h1: Int = readLine()!!.toInt()
    val m1: Int = readLine()!!.toInt()
    val s1: Int = readLine()!!.toInt()
    val h2: Int = readLine()!!.toInt()
    val m2: Int = readLine()!!.toInt()
    val s2: Int = readLine()!!.toInt()
    println((h2 - h1) * 3600 + (m2 - m1) * 60 + (s2 - s1) % 60)
}