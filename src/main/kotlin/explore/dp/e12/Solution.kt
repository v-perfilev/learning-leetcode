package explore.dp.e12

import kotlin.math.max

class Solution {
    fun maxProfit(k: Int, prices: IntArray): Int {
        val topDownRes = TopDownProfitCalculator().calc(k, prices)
        println("Top down: $topDownRes")
        val bottomUpRes = BottomUpProfitCalculator().calc(k, prices)
        println("Bottom up: $bottomUpRes")
        return bottomUpRes
    }

    companion object {
        interface ProfitCalculator {
            fun calc(k: Int, prices: IntArray): Int
        }

        /*
        TOP-DOWN
         */

        class TopDownProfitCalculator : ProfitCalculator {
            private lateinit var prices: IntArray
            private lateinit var cache: Array<Array<IntArray>>

            override fun calc(k: Int, prices: IntArray): Int {
                this.prices = prices
                this.cache = Array(prices.size) { Array(k + 1) { IntArray(2) } }
                return dp(0, k, 0)
            }

            private fun dp(i: Int, remaining: Int, holding: Int): Int {
                if (remaining == 0 || i == this.prices.size) return 0

                if (this.cache[i][remaining][holding] == 0) {
                    val doNothing = dp(i + 1, remaining, holding)
                    val doSomething = if (holding == 0) -this.prices[i] + dp(i + 1, remaining, 1)
                    else this.prices[i] + dp(i + 1, remaining - 1, 0)
                    this.cache[i][remaining][holding] = max(doNothing, doSomething)
                }

                return this.cache[i][remaining][holding]
            }
        }

        /*
        BOTTOM-UP
         */

        class BottomUpProfitCalculator : ProfitCalculator {
            override fun calc(k: Int, prices: IntArray): Int {
                val memo = Array(prices.size + 1) { Array(k + 1) { IntArray(2) } }

                for (i in prices.size - 1 downTo 0) {
                    for (remaining in 1..k) {
                        for (holding in 0..1) {
                            val doNothing = memo[i + 1][remaining][holding]
                            val doSomething = if (holding == 0) -prices[i] + memo[i + 1][remaining][1]
                            else prices[i] + memo[i + 1][remaining - 1][0]
                            memo[i][remaining][holding] = max(doNothing, doSomething)
                        }
                    }
                }

                return memo[0][k][0]
            }
        }
    }
}
