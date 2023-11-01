package problems.t28

class Solution {
    fun strStr(haystack: String, needle: String): Int {
        var counter = 0
        var i = 0
        while (i < haystack.length) {
            if (counter > 0 && haystack[i] != needle[counter]) {
                i -= counter - 1
                counter = 0
            }
            if (haystack[i] == needle[counter]) {
                counter++
            }
            if (counter == needle.length) {
                return i - counter + 1
            }

            i++
        }
        return -1
    }
}
