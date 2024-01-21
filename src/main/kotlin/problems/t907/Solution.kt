package problems.t907

class Solution {
    companion object {
        const val MOD = (1e9 + 7).toInt()
    }

    private lateinit var arr: IntArray
    private lateinit var memo: Array<IntArray>

    fun sumSubarrayMins(arr: IntArray): Int {
        this.arr = arr
        this.memo = Array(arr.size) { IntArray(arr.size) { -1 } }
        return arr.indices.map { dp(it, it) }.reduce { acc, sum -> (acc + sum) % MOD }
    }

    private fun dp(i: Int, iMin: Int): Int {
        if (i == arr.size) return 0
        if (memo[i][iMin] != -1) return memo[i][iMin]
        val newIMin = if (arr[i] < arr[iMin]) i else iMin
        memo[i][iMin] = (arr[newIMin] + dp(i + 1, newIMin)) % MOD
        return memo[i][iMin]
    }
}
