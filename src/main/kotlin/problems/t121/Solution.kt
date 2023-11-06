package problems.t121

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var totalProfit = 0
        var currentProfit = 0
        var min = prices[0]

        for (i in 1..prices.size) {
            if (prices[i] < min) min = prices[i]
            if (currentProfit > prices[i] - min) {
                totalProfit += currentProfit
                currentProfit = 0
                min = prices[i]
            } else {
                currentProfit = prices[i] - min
            }
        }

        return totalProfit + currentProfit
    }
}
