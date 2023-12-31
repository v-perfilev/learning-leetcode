package explore.bit.e9

class Solution {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (i in nums.indices) {
            result = result xor nums[i]
        }
        return result
    }
}
