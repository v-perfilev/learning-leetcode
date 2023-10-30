package explore.dp.e31

class Solution {
    companion object {
        const val MOD = (1e9 + 7).toInt()
    }

    private lateinit var memo: IntArray

    fun numTilings(n: Int): Int {
        this.memo = IntArray(n + 1)
        return dp(n)
    }

    private fun dp(n: Int): Int {
        if (n < 3) return n
        if (this.memo[n] == 0) {
            this.memo[n] = dp(n - 1) + dp(n - 2)
            this.memo[n] %= MOD
        }
        return this.memo[n]
    }
}
