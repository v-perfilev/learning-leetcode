package problems.t76

class Solution {
    fun minWindow(s: String, t: String): String {
        val targetMap = t.groupingBy { it }.eachCount()
        val countMap = t.toSet().associateWith { 0 }.toMutableMap()
        var minL = -1
        var minR = s.length + 1
        var l = 0
        var r = 0
        while (r < s.length) {
            if (countMap.containsKey(s[r])) {
                countMap[s[r]] = countMap[s[r]]!! + 1
            }

            while (l < r && canReduce(targetMap, countMap, s[l])) {
                if (countMap.containsKey(s[l])) {
                    countMap[s[l]] = countMap[s[l]]!!.minus(1)
                }
                l++
            }

            if (r - l < minR - minL && isValid(targetMap, countMap)) {
                minR = r
                minL = l
            }

            r++
        }
        return if (minL == -1) "" else s.substring(minL, minR + 1)
    }

    private fun isValid(targetMap: Map<Char, Int>, countMap: Map<Char, Int>): Boolean {
        for (c in targetMap.keys) {
            if (targetMap[c]!! > countMap[c]!!) return false
        }
        return true
    }

    private fun canReduce(targetMap: Map<Char, Int>, countMap: Map<Char, Int>, c: Char): Boolean {
        if (!targetMap.containsKey(c)) return true
        return targetMap[c]!! < countMap[c]!!
    }
}
