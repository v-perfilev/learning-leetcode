package problems.t1759

class Solution {
    fun countHomogenous(s: String): Int {
        if (s.isEmpty()) return 0
        var sum = 0L
        var c = s[0]
        var counter = 1L
        for (i in 1..<s.length) {
            if (c == s[i]) {
                counter++
            } else {
                sum += calcSum(counter)
                counter = 1L
                c = s[i]
            }
        }
        return ((sum + calcSum(counter)) % (1e9 + 7)).toInt()
    }

    private fun calcSum(value: Long): Long = if (value > 0) value * (value + 1) / 2 else 0
}
