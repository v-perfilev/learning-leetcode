package explore.systemdesign.e9

class Uber {
    private val cabs = mutableListOf<Cab>()
    private val customerCabMap = mutableMapOf<Int, Int>()

    fun addCab(cabX: Int, cabY: Int) {
        val cabId = cabs.size
        val cab = Cab(cabId, cabX, cabY)
        cabs.add(cab)
    }

    fun startTrip(customerID: Int, customerX: Int, customerY: Int): IntArray {
        getNearestCabObjs(1, customerX, customerY).firstOrNull()?.let {
            customerCabMap[customerID] = it.id
            it.customerId = customerID
            return intArrayOf(it.x, it.y)
        } ?: run {
            return intArrayOf(-1, -1)
        }
    }

    fun endTrip(customerID: Int, customerX: Int, customerY: Int) {
        customerCabMap.remove(customerID)?.also {
            cabs[it].x = customerX
            cabs[it].y = customerY
            cabs[it].customerId = null
        }
    }

    fun getNearestCabs(k: Int, x: Int, y: Int): List<List<Int>> {
        return getNearestCabObjs(k, x, y)
            .map { listOf(it.x, it.y) }
    }

    private fun getNearestCabObjs(k: Int, x: Int, y: Int): List<Cab> {
        return cabs
            .filter { it.customerId == null }
            .sortedWith(
                Comparator
                    .comparingInt<Cab> { it.calcSquareDistance(x, y) }
                    .thenComparingInt { it.x }
                    .thenComparingInt { it.y }
            )
            .take(k)
            .sortedWith(
                Comparator
                    .comparingInt<Cab> { it.x }
                    .thenComparingInt { it.y }
            )
    }

    private class Cab(val id: Int, var x: Int, var y: Int) {
        var customerId: Int? = null

        fun calcSquareDistance(targetX: Int, targetY: Int): Int {
            val xDiff = x - targetX
            val yDiff = y - targetY
            return xDiff * xDiff + yDiff * yDiff
        }
    }
}
