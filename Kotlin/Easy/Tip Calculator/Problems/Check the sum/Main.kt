fun main() {
    // put your code here
    val a: Int = readLine()!!.toInt()
    val b: Int = readLine()!!.toInt()
    val c: Int = readLine()!!.toInt()
    println(a + b == 20 || a + c == 20 || b + c == 20)
}