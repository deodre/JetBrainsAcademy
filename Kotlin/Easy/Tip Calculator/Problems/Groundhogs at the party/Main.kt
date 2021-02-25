fun main() {
    // write your code here
    val reeses: Int = readLine()!!.toInt()
    val isWeekend: Boolean = readLine()!!.toBoolean()
    println(reeses >= 10 && reeses <= 20 && !isWeekend || reeses >= 15 && reeses <= 25 && isWeekend)
}