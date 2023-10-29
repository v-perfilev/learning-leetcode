package explore.dp.e30

class Solution {
    companion object {
        const val MOD = (1e9 + 7).toInt()
    }

    private lateinit var memo: Array<IntArray>

    fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
        this.memo = Array(n + 1) { IntArray(target + 1) { -1 } }
        return dp(n, k, target)
    }

    private fun dp(n: Int, k: Int, target: Int): Int {
        if (n == 0 && target == 0) return 1
        if (n == 0 || target < 0) return 0
        if (this.memo[n][target] == -1) {
            this.memo[n][target] = 0
            for (i in 1..k) {
                this.memo[n][target] += dp(n - 1, k, target - i)
                this.memo[n][target] %= MOD
            }
        }
        return this.memo[n][target]
    }
}
