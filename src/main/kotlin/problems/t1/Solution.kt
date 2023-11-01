package problems.t1

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            map[target - nums[i]]?.let { return intArrayOf(it, i) }
            map[nums[i]] = i
        }
        throw Exception()
    }
}
