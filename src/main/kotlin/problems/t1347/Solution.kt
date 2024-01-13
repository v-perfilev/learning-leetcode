package problems.t1347

import kotlin.math.abs

class Solution {
    fun minSteps(s: String, t: String): Int {
        val arr = IntArray(26)
        for (i in s.indices) {
            arr[s[i].code - 'a'.code]++
            arr[t[i].code - 'a'.code]--
        }
        return arr.filter { it != 0 }.sumOf { abs(it) } / 2
    }
}
