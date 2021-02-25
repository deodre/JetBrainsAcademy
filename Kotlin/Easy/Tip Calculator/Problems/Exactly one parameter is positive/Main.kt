fun main() {
    // put your code here
    val n1: Int = readLine()!!.toInt()
    val n2: Int = readLine()!!.toInt()
    val n3: Int = readLine()!!.toInt()
    println(n1 > 0 && n2 <= 0 && n3 <= 0 || n1 <= 0 && n2 > 0 && n3 <= 0 || n1 <= 0 && n2 <= 0 && n3 > 0)
}