package problems.t136

class Solution {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (i in nums.indices) {
            result = result xor nums[i]
        }
        return result
        return nums.reduce{acc, i ->  acc xor i}
    }
}
