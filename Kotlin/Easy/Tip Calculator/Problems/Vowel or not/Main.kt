// write your function here
fun isVowel(letter: Char): Boolean {
    val vowels: Array<Char> = arrayOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    return vowels.contains(letter)
}

fun main() {

    val letter = readLine()!!.first()

    println(isVowel(letter))
}