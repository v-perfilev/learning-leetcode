package problems.t1066

import kotlin.math.abs

class Solution {
    private lateinit var workers: Array<IntArray>
    private lateinit var bikes: Array<IntArray>
    private lateinit var memo: IntArray

    fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): Int {
        this.workers = workers
        this.bikes = bikes
        this.memo = IntArray(1024) { -1 }
        return dp(0, 0)
    }

    private fun dp(i: Int, mask: Int): Int {
        if (i >= workers.size) return 0
        if (memo[mask] != -1) return memo[mask]
        var minDistance = Int.MAX_VALUE
        for (j in bikes.indices) {
            if (mask and (1 shl j) == 0) {
                minDistance = minOf(
                    minDistance,
                    calcDistance(workers[i], bikes[j]) + dp(i + 1, mask or (1 shl j))
                )
            }
        }
        memo[mask] = minDistance
        return memo[mask]
    }

    private fun calcDistance(worker: IntArray, bike: IntArray): Int =
        abs(worker[0] - bike[0]) + abs(worker[1] - bike[1])
}
