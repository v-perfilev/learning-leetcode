package problems.t125

class Solution {
    fun isPalindrome(s: String): Boolean {
        val normalizedString = s.replace("[^A-Za-z0-9]".toRegex(), "").lowercase()
        val halfLength = normalizedString.length / 2
        for (i in 0..<halfLength) {
            if (normalizedString[i] != normalizedString[normalizedString.length - 1 - i]) {
                return false
            }
        }
        return true
    }
}
