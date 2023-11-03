package problems.t58

class Solution {
    fun lengthOfLastWord(s: String): Int {
        var isWord = false
        var counter = 0
        for (i in s.length - 1 downTo 0) {
            if (isWord && s[i] != ' ') {
                counter++
            } else if (isWord && s[i] == ' ') {
                break
            } else if (!isWord && s[i] != ' ') {
                counter++
                isWord = true
            }
        }
        return counter
    }
}
