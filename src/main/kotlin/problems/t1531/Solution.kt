package problems.t1531

import kotlin.math.min

internal class Solution {
    private val memo: MutableMap<Int, Int> = HashMap()
    var add = setOf(1, 9, 99)
    fun getLengthOfOptimalCompression(s: String, k: Int): Int {
        return dp(s, 0, ('a'.code + 26).toChar(), 0, k)
    }

    private fun dp(s: String, idx: Int, lastChar: Char, lastCharCount: Int, k: Int): Int {
        if (k < 0) {
            return Int.MAX_VALUE / 2
        }
        if (idx == s.length) {
            return 0
        }
        val key = idx * 101 * 27 * 101 + (lastChar.code - 'a'.code) * 101 * 101 + lastCharCount * 101 + k
        if (memo.containsKey(key)) {
            return memo[key]!!
        }
        val deleteChar = dp(s, idx + 1, lastChar, lastCharCount, k - 1)
        val keepChar: Int = if (s[idx] == lastChar) {
            dp(s, idx + 1, lastChar, lastCharCount + 1, k) + if (add.contains(lastCharCount)) 1 else 0
        } else {
            dp(s, idx + 1, s[idx], 1, k) + 1
        }
        val res = min(keepChar, deleteChar)
        memo[key] = res
        return res
    }
}
