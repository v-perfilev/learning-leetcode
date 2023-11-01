package problems.t9

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        val str = x.toString()
        for (i in 0..str.length / 2) {
            if (str[i] != str[str.length - i - 1]) return false
        }
        return true
    }
}
