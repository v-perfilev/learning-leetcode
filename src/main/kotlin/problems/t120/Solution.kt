package problems.t120

import kotlin.math.min

class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        if (triangle.size == 1) return triangle[0][0]
        var cache = triangle.last()
        for (j in triangle.size - 2 downTo 0) {
            val currentCache = mutableListOf<Int>()
            for (i in triangle[j].indices) {
                val currentValue = triangle[j][i] + min(cache[i], cache[i + 1])
                currentCache.add(currentValue)
            }
            cache = currentCache
        }
        return cache[0]
    }
}
