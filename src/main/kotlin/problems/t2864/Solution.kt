package problems.t2864

class Solution {
    fun maximumOddBinaryNumber(s: String): String {
        val ones = s.count { it == '1' } - 1
        val sb = StringBuilder()
        for (i in s.indices) {
            val c = if (i < ones || i == s.length - 1) '1' else '0'
            sb.append(c)
        }
        return sb.toString()
    }
}
