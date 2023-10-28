package explore.dp.e26

class Solution {
    fun minCostII(costs: Array<IntArray>): Int {
        val h = costs.size
        val c = costs[0].size
        val memo = Array(h + 1) { IntArray(c) }
        for (i in h - 1 downTo 0) {
            for (color in 0..<c) {
                val nextPrice = Array(c) { it }.filter { it != color }.map { memo[i + 1][it] }.min()
                memo[i][color] = nextPrice + costs[i][color]
            }
        }
        return Array(c) { it }.map { memo[0][it] }.min()
    }
}
