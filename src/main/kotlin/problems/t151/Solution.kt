package problems.t151

class Solution {
    fun reverseWords(s: String): String {
        val sb = StringBuilder()
        var counter = 0
        for (i in s.length - 1 downTo 0) {
            if (s[i] != ' ') {
                counter++
            }
            if (counter > 0 && s[i] == ' ') {
                append(s, i + 1, counter, sb)
                counter = 0
            }
            if (counter > 0 && i == 0) {
                append(s, i, counter, sb)
            }
        }
        return sb.toString()
    }

    private fun append(s: String, i: Int, counter: Int, sb: StringBuilder) {
        if (sb.isNotEmpty()) sb.append(' ')
        sb.append(s.substring(i, i + counter))
    }
}
