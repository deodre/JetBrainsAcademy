fun main() {
    // write your code here
    val (hour, minute, second) = readLine()!!.split(" ")
    val (day, month, year) = readLine()!!.split(" ")
    println("$hour:$minute:$second $day/$month/$year")
}