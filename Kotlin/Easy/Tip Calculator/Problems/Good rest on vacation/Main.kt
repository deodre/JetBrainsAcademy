fun main() {
    val durationInDays: Int = readLine()!!.toInt()
    val totalFoodCostPerDay: Int = readLine()!!.toInt()
    val oneWayFlightCost: Int = readLine()!!.toInt()
    val costOfOneNightInHotel: Int = readLine()!!.toInt()
    println(durationInDays * totalFoodCostPerDay + oneWayFlightCost * 2 + (durationInDays - 1) * costOfOneNightInHotel)
}