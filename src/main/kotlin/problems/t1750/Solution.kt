package problems.t1750

class Solution {
    fun minimumLength(s: String): Int {
        var a = 0
        var b = s.length - 1
        while (a < b && s[a] == s[b]) {
            val symbol = s[a]
            while (a < s.length && s[a] == symbol && a <= b) a++
            while (b >= 0 && s[b] == symbol && a <= b) b--
        }
        return if (a <= b) b - a + 1 else 0
    }
}
