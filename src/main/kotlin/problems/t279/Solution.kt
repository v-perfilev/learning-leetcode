package problems.t279

class Solution {
    private lateinit var memo: IntArray

    fun numSquares(n: Int): Int {
        this.memo = IntArray(n + 1) { -1 }
        return dp(n)
    }

    private fun dp(n: Int): Int {
        if (n == 0) return 0
        if (n < 0) return Int.MAX_VALUE / 2
        if (this.memo[n] != -1) return this.memo[n]

        var min = Int.MAX_VALUE / 2
        var i = 1
        var square = i * i
        while (square <= n) {
            min = minOf(min, 1 + dp(n - square))
            i++
            square = i * i
        }

        this.memo[n] = min
        return this.memo[n]
    }
}
