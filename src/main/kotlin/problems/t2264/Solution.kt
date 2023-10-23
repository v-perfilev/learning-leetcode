package problems.t2264

class Solution {
    fun largestGoodInteger(num: String): String {
        var max: Char? = null
        var prev = num[0]
        var counter = 1
        for (i in 1..<num.length) {
            if (num[i] == prev) counter++
            else counter = 1
            if (counter == 3 && (max == null || num[i] > max)) {
                max = num[i]
            }
            prev = num[i]
        }
        return max?.toString()?.repeat(3) ?: ""
    }
}
