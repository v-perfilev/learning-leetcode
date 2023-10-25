package explore.dp.e14

import kotlin.math.min

class Solution {

    fun minCostClimbingStairs(cost: IntArray): Int {
        var prev2 = cost[0]
        var prev1 = cost[1]
        for (i in 2..<cost.size) {
            val tmp = prev1
            prev1 = min(prev1, prev2) + cost[i]
            prev2 = tmp
        }
        return min(prev1, prev2)
    }
}
