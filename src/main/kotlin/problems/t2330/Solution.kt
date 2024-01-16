package problems.t2330

class Solution {
    fun makePalindrome(s: String): Boolean {
        return validPalindrom(s, 0, s.length - 1, 2)
    }

    private fun validPalindrom(s: String, a: Int, b: Int, changesLeft: Int): Boolean {
        if (a >= b) return true
        if (s[a] != s[b] && changesLeft == 0) return false
        if (s[a] == s[b]) return validPalindrom(s, a + 1, b - 1, changesLeft)
        return validPalindrom(s, a + 1, b - 1, changesLeft - 1)
    }
}
