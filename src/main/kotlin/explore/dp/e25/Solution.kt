package explore.dp.e25

import kotlin.system.measureTimeMillis

class Solution {
    fun minCost(costs: Array<IntArray>): Int {
        // calculate top down result
        var topDownRes: Int
        val topDownTimeInMillis = measureTimeMillis {
            topDownRes = TopDownCostCalculator().calc(costs)
        }
        println("Top down: $topDownRes in $topDownTimeInMillis ms")

        // calculate bottom up result
        var bottomUpRes: Int
        val bottomUpTimeInMillis = measureTimeMillis {
            bottomUpRes = BottomUpCostCalculator().calc(costs)
        }
        println("Bottom up: $bottomUpRes in $bottomUpTimeInMillis ms")

        // return bottom up result
        return bottomUpRes
    }

    companion object {
        interface CostCalculator {
            fun calc(costs: Array<IntArray>): Int
        }

        /*
        TOP-DOWN
         */

        class TopDownCostCalculator : CostCalculator {
            private lateinit var memo: Array<IntArray>
            private lateinit var costs: Array<IntArray>

            override fun calc(costs: Array<IntArray>): Int {
                this.memo = Array(costs.size) { IntArray(3) }
                this.costs = costs
                return minOf(dp(0, 0), dp(0, 1), dp(0, 2))
            }

            private fun dp(i: Int, color: Int): Int {
                if (i == this.costs.size) return 0
                if (this.memo[i][color] == 0) {
                    this.memo[i][color] = Array(3) { it }
                        .filter { it != color }
                        .map { dp(i + 1, it) }
                        .min() + this.costs[i][color]
                    var nextPrice = when (color) {
                        0 -> minOf(dp(i + 1, 1), dp(i + 1, 2))
                        1 -> minOf(dp(i + 1, 0), dp(i + 1, 2))
                        else -> minOf(dp(i + 1, 0), dp(i + 1, 1))
                    }
                    memo[i][color] = nextPrice + costs[i][color]
                }
                return this.memo[i][color]
            }
        }

        /*
        BOTTOM-UP
         */

        class BottomUpCostCalculator : CostCalculator {
            override fun calc(costs: Array<IntArray>): Int {
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
    }
}
