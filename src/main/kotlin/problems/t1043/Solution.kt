package problems.t1043

class Solution {
    fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
        val n = arr.size
        val dp = IntArray(n + 1)

        for (i in 1..n) {
            var maxVal = 0
            for (j in 1..minOf(k, i)) {
                maxVal = maxOf(maxVal, arr[i - j])
                dp[i] = maxOf(dp[i], dp[i - j] + maxVal * j)
            }
        }

        return dp[n]
    }
}
