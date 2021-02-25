fun main() {
    // write your code here
    val str: String = readLine()!!
    val n: Int = readLine()!!.toInt()
    println("Symbol # $n of the string \"$str\" is \'${str[n - 1]}\'")
}