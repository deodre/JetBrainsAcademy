import kotlin.math.pow

fun main() {
    // put your code here
    val number: Int = readLine()!!.toInt()
    var sum: Int = 0
    for (i in 0..2) {
        sum += number / 10.0.pow(i).toInt() % 10
    }
    println(sum)
}