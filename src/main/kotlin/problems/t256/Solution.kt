package problems.t256

class Solution {
    fun minCost(costs: Array<IntArray>): Int {
        val memo = Array(costs.size + 1) { IntArray(3) }
        for (i in costs.indices.reversed()) {
            for (color in 0..2) {
                var nextPrice = when (color) {
                    0 -> minOf(memo[i + 1][1], memo[i + 1][2])
                    1 -> minOf(memo[i + 1][0], memo[i + 1][2])
                    else -> minOf(memo[i + 1][0], memo[i + 1][1])
                }
                memo[i][color] = nextPrice + costs[i][color]
            }
        }
        return minOf(memo[0][0], memo[0][1], memo[0][2])
    }
}
