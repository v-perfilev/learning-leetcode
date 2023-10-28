package explore.dp.e24

import kotlin.system.measureTimeMillis

class Solution {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        // calculate top down result
        var topDownRes: Int
        val topDownTimeInMillis = measureTimeMillis {
            topDownRes = TopDownProfitCalculator().calcProfit(prices, fee)
        }
        println("Top down: $topDownRes in $topDownTimeInMillis ms")

        // calculate bottom up result
        var bottomUpRes: Int
        val bottomUpTimeInMillis = measureTimeMillis {
            bottomUpRes = BottomUpProfitCalculator().calcProfit(prices, fee)
        }
        println("Bottom up: $bottomUpRes in $bottomUpTimeInMillis ms")

        // return bottom up result
        return bottomUpRes
    }

    companion object {
        interface ProfitCalculator {
            fun calcProfit(prices: IntArray, fee: Int): Int
        }

        /*
        TOP-DOWN
         */

        class TopDownProfitCalculator : ProfitCalculator {
            private lateinit var memo: Array<IntArray>
            private lateinit var prices: IntArray
            private var fee = 0

            override fun calcProfit(prices: IntArray, fee: Int): Int {
                this.memo = Array(prices.size) { IntArray(2) }
                this.prices = prices
                this.fee = fee
                return dp(0, 0)
            }

            private fun dp(i: Int, holding: Int): Int {
                if (i == this.prices.size) return 0
                if (this.memo[i][holding] == 0) {
                    val doNothing = dp(i + 1, holding)
                    val doSomething = if (holding == 1) this.prices[i] + dp(i + 1, 0) - this.fee
                    else -this.prices[i] + dp(i + 1, 1)
                    this.memo[i][holding] = maxOf(doNothing, doSomething)
                }
                return this.memo[i][holding]
            }
        }

        /*
        BOTTOM-UP
         */

        class BottomUpProfitCalculator : ProfitCalculator {
            override fun calcProfit(prices: IntArray, fee: Int): Int {
                val memo = Array(prices.size + 1) { IntArray(2) }

                for (i in prices.indices.reversed()) {
                    for (holding in 0..1) {
                        val doNothing = memo[i + 1][holding]
                        val doSomething = if (holding == 1) prices[i] + memo[i + 1][0] - fee
                        else -prices[i] + memo[i + 1][1]
                        memo[i][holding] = maxOf(doNothing, doSomething)
                    }
                }

                return memo[0][0]
            }
        }
    }
}
