package problems.t1216

class Solution {
    private lateinit var memo: Array<IntArray>
    private lateinit var s: String
    private var k: Int = 0

    fun isValidPalindrome(s: String, k: Int): Boolean {
        val memoArrSize = s.length / 2 + 1 + k
        this.memo = Array(memoArrSize) { IntArray(memoArrSize) { -1 } }
        this.s = s
        this.k = k
        return dp(0, 0) <= k
    }

    private fun dp(l: Int, r: Int): Int {
        val rIdx = s.length - 1 - r
        if (l >= rIdx) return 0
        if (l >= s.length / 2 + 1 + k || r >= s.length / 2 + 1 + k) return Int.MAX_VALUE
        if (memo[l][r] == -1) {
            memo[l][r] =
                if (s[l] == s[rIdx]) dp(l + 1, r + 1)
                else minOf(dp(l + 1, r), dp(l, r + 1)) + 1
        }
        return memo[l][r]
    }
}
