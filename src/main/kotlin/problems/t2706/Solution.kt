package problems.t2706

class Solution {
    fun buyChoco(prices: IntArray, money: Int): Int {
        val sortedPrices = prices.sortedArray()
        val res = money - sortedPrices[0] - sortedPrices[1]
        return if (res >= 0) res else money
    }
}
