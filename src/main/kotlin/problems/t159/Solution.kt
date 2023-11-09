package problems.t159

class Solution {
    fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
        val charMap = mutableMapOf<Char, Int>()
        var maxLength = 0
        var a = 0
        var b = 0
        while (b < s.length) {
            charMap[s[b]] = b
            while (charMap.size > 2) {
                if (a == charMap[s[a]]) charMap.remove(s[a])
                a++
            }
            b++
            maxLength = maxOf(maxLength, b - a)
        }
        return maxLength
    }
}
