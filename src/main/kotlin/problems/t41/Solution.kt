package problems.t41

import kotlin.math.abs

class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size

        nums.count { it == 1 }.let {
            if (it == 0) return 1
        }

        for (i in nums.indices) {
            if (nums[i] <= 0 || nums[i] > n) nums[i] = 1
        }

        for (i in nums.indices) {
            val a = abs(nums[i])
            if (a == n) nums[0] = -abs(nums[0])
            else nums[a] = -abs(nums[a])
        }

        for (i in 1..<n) {
            if (nums[i] > 0) return i
        }

        if (nums[0] > 0) return n

        return n + 1
    }
}
