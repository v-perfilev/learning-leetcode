package problems.t629

import kotlin.math.min

class Solution {
    companion object {
        const val MOD = 1e9.toInt() + 7
    }

    private lateinit var memo: Array<IntArray>

    fun kInversePairs(n: Int, k: Int): Int {
        this.memo = Array(n + 1) { IntArray(k + 1) { -1 } }
        return dp(n, k)
    }

    private fun dp(n: Int, k: Int): Int {
        if (n == 0) return 0
        if (k == 0) return 1
        if (memo[n][k] != -1) return memo[n][k]
        memo[n][k] = 0
        for (i in 0..min(k, (n - 1))) {
            memo[n][k] = (memo[n][k] + dp(n - 1, k - i)) % MOD
        }
        return memo[n][k]
    }
}
