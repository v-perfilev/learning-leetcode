package explore.datastructure.dp.e2

class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        var prev2 = cost[0]
        var prev1 = cost[1]
        for (i in 2..<cost.size) {
            val tmp = prev1
            prev1 = minOf(prev1, prev2) + cost[i]
            prev2 = tmp
        }
        return minOf(prev1, prev2)
    }
}
