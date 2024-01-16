package problems.t680

class Solution {
    fun validPalindrome(s: String): Boolean {
        return validPalindrom(s, 0, s.length - 1, 1)
    }

    private fun validPalindrom(s: String, a: Int, b: Int, skips: Int): Boolean {
        if (a >= b) return true
        if (s[a] != s[b] && skips == 0) return false
        if (s[a] == s[b]) return validPalindrom(s, a + 1, b - 1, skips)
        return validPalindrom(s, a + 1, b, skips - 1) || validPalindrom(s, a, b - 1, skips - 1)
    }
}
