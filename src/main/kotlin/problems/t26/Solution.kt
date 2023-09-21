package problems.t26

class Solution {
    fun majorityElement(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        nums.forEach { map[it] = map.getOrDefault(it, 0) + 1 }
        return map.maxBy { it.value }.key
    }
}
