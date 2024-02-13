package problems.t2108

class Solution {
    fun firstPalindrome(words: Array<String>): String {
        for (word in words) {
            if (word == word.reversed()) return word
        }
        return ""
    }
}
