package problems.t791

class Solution {
    fun customSortString(order: String, s: String): String {
        val sMap = s.groupingBy { it }.eachCount().toMutableMap()
        val sb = StringBuilder()
        order.forEach { c ->
            val count = sMap[c] ?: 0
            repeat(count) { sb.append(c) }
            sMap.remove(c)
        }
        sMap.entries.forEach { (c, count) ->
            repeat(count) { sb.append(c) }
        }
        return sb.toString()
    }
}
