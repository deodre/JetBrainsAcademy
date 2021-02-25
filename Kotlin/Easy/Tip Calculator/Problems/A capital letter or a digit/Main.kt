fun main() {
    // write your code here
    val character: Char = readLine()!!.first()
    println((character.isDigit() || character.isUpperCase()) && character != '0')
}