fun main() {
    // write your code here
    val hasInvitation: Boolean = readLine().toBoolean()
    val broughtAGift: Boolean = readLine().toBoolean()
    if (hasInvitation && broughtAGift) {
        print(true)
    } else {
        print(false)
    }
}