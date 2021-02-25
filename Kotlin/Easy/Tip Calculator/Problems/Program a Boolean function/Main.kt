fun main() {
    // write your code here
    val x: Boolean = readLine().toBoolean()
    val y: Boolean = readLine().toBoolean()
    val z: Boolean = readLine().toBoolean()
    println(!(x && y) || z)
}