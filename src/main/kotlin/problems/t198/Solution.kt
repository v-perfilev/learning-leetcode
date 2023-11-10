package problems.t198

import kotlin.math.max

class Solution {
    fun rob(nums: IntArray): Int {
        var rob1 = 0
        var rob2 = 0

        for (i in nums.indices) {
            val max = max(rob1 + nums[i], rob2)
            rob1 = rob2
            rob2 = max
        }

        return max(rob1, rob2)
    }
}
