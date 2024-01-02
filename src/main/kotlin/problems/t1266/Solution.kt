package problems.t1266

import kotlin.math.abs

class Solution {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var sum = 0
        var prev = points[0]
        for (i in 1..<points.size) {
            val cur = points[i]
            val dx = abs(cur[0] - prev[0])
            val dy = abs(cur[1] - prev[1])
            val dMax = maxOf(dx, dy)
            sum += dMax
            prev = cur
        }
        return sum
    }
}
