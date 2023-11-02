package problems.t44

class Solution {
    private lateinit var s: String
    private lateinit var p: String
    private lateinit var memo: Array<IntArray>

    fun isMatch(s: String, p: String): Boolean {
        this.s = s
        this.p = p
        this.memo = Array(s.length + 1) { IntArray(p.length + 1) { -1 } }
        return dp(0, 0) == 1
    }

    private fun dp(sIdx: Int, pIdx: Int): Int {
        if (sIdx == s.length && pIdx == p.length) return 1
        if (sIdx == s.length) return if (p[pIdx] == '*') dp(sIdx, pIdx + 1) else 0
        if (pIdx == p.length) return 0

        if (memo[sIdx][pIdx] != -1) return memo[sIdx][pIdx]

        val sSymbol = s[sIdx]
        val pSymbol = p[pIdx]
        memo[sIdx][pIdx] = when (pSymbol) {
            '?' -> dp(sIdx + 1, pIdx + 1)
            '*' -> dp(sIdx + 1, pIdx) or dp(sIdx, pIdx + 1)
            else -> if (sSymbol == pSymbol) dp(sIdx + 1, pIdx + 1) else 0
        }

        return memo[sIdx][pIdx]
    }
}
