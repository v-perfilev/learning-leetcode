package explore.dp.e18

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var min = Int.MAX_VALUE
        var sum = Int.MIN_VALUE
        prices.forEach {
            min = minOf(it, min)
            sum = maxOf(sum, it - min)
        }
        return sum
    }
}
