fun main() {
    // put your code here
    val number: Int = readLine()!!.toInt()
    if (number > 9) {
        println(number / 10 % 10)
    } else {
        println(0)
    }
}