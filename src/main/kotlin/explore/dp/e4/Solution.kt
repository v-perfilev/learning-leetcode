package explore.dp.e4

import kotlin.math.max

class Solution {
    fun deleteAndEarn(nums: IntArray): Int {
        val values = mutableMapOf<Int, Int>()
        nums.forEach { values[it] = (values[it] ?: 0) + it }
        val keys = values.keys.sorted()

        var mem2 = 0
        var mem1 = values[keys[0]]!!

        for (i in 1..<keys.size) {
            val tmp = mem1
            val previousKey = keys[i - 1]
            val currentKey = keys[i]
            if (currentKey == previousKey + 1) {
                mem1 = max(mem2 + values[currentKey]!!, mem1)
            } else {
                mem1 += values[currentKey]!!
            }
            mem2 = tmp
        }
        return mem1
    }
}
