package problems.t32

class Solution {
    private lateinit var s: String
    private lateinit var memo: IntArray

    fun longestValidParentheses(s: String): Int {
        if (s.length < 2) return 0
        this.s = s
        this.memo = IntArray(s.length) { -1 }
        this.s.forEachIndexed { index, _ -> dp(index) }
        return this.memo.max()
    }

    private fun dp(i: Int): Int {
        if (i >= s.length - 1) return 0
        if (memo[i] != -1) return memo[i]

        memo[i] = 0
        if (s[i] == '(' && s[i + 1] == ')') {
            memo[i] = 2 + dp(i + 2)
        } else if (
            s[i] == '('
            && i + dp(i + 1) + 1 < s.length
            && s[i + 1 + dp(i + 1)] == ')'
        ) {
            memo[i] = 2 + dp(i + 1) + dp(i + 2 + dp(i + 1))
        }

        return memo[i]
    }
}
