fun main() {
    // write your code here
    val firstAnswer: Boolean = readLine().toBoolean()
    val secondAnswer: Boolean = readLine().toBoolean()
    val confession: Boolean = readLine().toBoolean()
    println(!(firstAnswer xor secondAnswer) xor confession)
}