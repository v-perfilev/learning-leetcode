package problems.t1624

class Solution {
    fun maxLengthBetweenEqualCharacters(s: String): Int {
        val map = mutableMapOf<Char, IntArray>()
        s.forEachIndexed { index, c ->
            if (map.containsKey(c)) map[c]!![1] = index
            else map[c] = intArrayOf(index, -1)
        }
        var max = -1
        map.forEach { (_, value) ->
            if (value[1] - value[0] > 0) max = maxOf(max, value[1] - value[0] - 1)
        }
        return max
    }
}
