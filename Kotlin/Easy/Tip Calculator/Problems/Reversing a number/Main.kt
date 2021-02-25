import kotlin.math.pow

fun main() {
    // put your code here
    val number: Int = readLine()!!.toInt()
    var reverse: Int = 0
    for (i in 0..2) {
        reverse *= 10
        reverse += number / 10.0.pow(i).toInt() % 10
    }
    println(reverse)
}