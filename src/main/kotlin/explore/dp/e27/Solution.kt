package explore.dp.e27

import kotlin.system.measureTimeMillis

class Solution {
    fun minCost(houses: IntArray, cost: Array<IntArray>, m: Int, n: Int, target: Int): Int {
        // calculate top down result
        var topDownRes: Int
        val topDownTimeInMillis = measureTimeMillis {
            topDownRes = TopDownCostCalculator().minCost(houses, cost, m, n, target)
        }
        println("Top down: $topDownRes in $topDownTimeInMillis ms")

        // calculate bottom up result
        var bottomUpRes: Int
        val bottomUpTimeInMillis = measureTimeMillis {
            bottomUpRes = BottomUpCostCalculator().minCost(houses, cost, m, n, target)
        }
        println("Bottom up: $bottomUpRes in $bottomUpTimeInMillis ms")

        // return bottom up result
        return bottomUpRes
    }

    companion object {
        interface CostCalculator {
            fun minCost(houses: IntArray, cost: Array<IntArray>, m: Int, n: Int, target: Int): Int
        }

        /*
        TOP-DOWN
         */

        class TopDownCostCalculator : CostCalculator {
            private lateinit var memo: Array<Array<IntArray>>
            private lateinit var houses: IntArray
            private lateinit var cost: Array<IntArray>
            private var m = 0
            private var n = 0
            private var target = 0

            override fun minCost(houses: IntArray, cost: Array<IntArray>, m: Int, n: Int, target: Int): Int {
                this.memo = Array(m) { Array(n + 1) { IntArray(target) } }
                this.houses = houses
                this.cost = cost
                this.m = m
                this.n = n
                this.target = target
                val res = dp(0, houses[0], 0)
                return if (res >= Int.MAX_VALUE / 2) -1 else res
            }

            private fun dp(i: Int, color: Int, neighborhood: Int): Int {
                if (neighborhood == this.target) return Int.MAX_VALUE / 2
                if (i == this.m && neighborhood != this.target - 1) return Int.MAX_VALUE / 2
                if (i == this.m && neighborhood == this.target - 1) return 0
                if (this.memo[i][color][neighborhood] == 0) {
                    if (this.houses[i] != 0) {
                        val newNeighborhood = if (this.houses[i] != color && i != 0) neighborhood + 1 else neighborhood
                        this.memo[i][color][neighborhood] = dp(i + 1, this.houses[i], newNeighborhood)
                    } else {
                        var min = Int.MAX_VALUE
                        for (j in 0..<n) {
                            val newNeighborhood = if (j + 1 != color && i != 0) neighborhood + 1 else neighborhood
                            min = minOf(min, this.cost[i][j] + dp(i + 1, j + 1, newNeighborhood))
                        }
                        this.memo[i][color][neighborhood] = min
                    }
                }
                return this.memo[i][color][neighborhood]
            }
        }

        /*
        BOTTOM-UP
        !!! THERE IS A BUG !!!
         */

        class BottomUpCostCalculator : CostCalculator {
            override fun minCost(houses: IntArray, cost: Array<IntArray>, m: Int, n: Int, target: Int): Int {
                val memo = Array(m + 1) { Array(n + 1) { IntArray(target) } }
                for (i in m - 1 downTo 0) {
                    for (color in 0..n) {
                        for (neighborhood in 0..<target) {
                            if (houses[i] != 0 && houses[i] != color) {
                                memo[i][color][neighborhood] = Int.MAX_VALUE / 2
                            } else if (houses[i] != 0) {
                                var min = Int.MAX_VALUE / 2
                                for (j in 1..n) {
                                    val newNeighborhood = if (j != houses[i]) neighborhood - 1 else neighborhood
                                    if (newNeighborhood in 0..<target) {
                                        min = minOf(min, memo[i + 1][j][newNeighborhood])
                                    }
                                }
                                memo[i][color][neighborhood] = min
                            } else {
                                var min = Int.MAX_VALUE / 2
                                for (j in 1..n) {
                                    val newNeighborhood = if (j != color) neighborhood - 1 else neighborhood
                                    if (newNeighborhood in 0..<target) {
                                        min = minOf(min, cost[i][j - 1] + memo[i + 1][j][newNeighborhood])
                                    }
                                }
                                memo[i][color][neighborhood] = min
                            }
                        }
                    }
                }
                val res = memo[0].map { it[target - 1] }.min()
                return if (res >= Int.MAX_VALUE / 2) -1 else res
            }
        }
    }
}
