package explore.dp.e13

import kotlin.math.max

class Solution {
    fun maxProfit(prices: IntArray): Int {
        val memo = Array(prices.size + 1) { Array(2) { IntArray(2) } }

        for (i in prices.size - 1 downTo 0) {
            for (cooldown in 0..1) {
                for (holding in 0..1) {
                    val doNothing = memo[i + 1][0][holding]
                    val doSomething = if (holding == 0) -prices[i] + memo[i + 1][0][1]
                    else prices[i] + memo[i + 1][1][0]
                    memo[i][cooldown][holding] = if (cooldown == 0) max(doNothing, doSomething)
                    else doNothing
                }
            }
        }

        return memo[0][0][0]
    }
}
