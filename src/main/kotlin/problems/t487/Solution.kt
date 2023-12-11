package problems.t487

class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var left = 0
        var zeroCounter = 0
        var max = 0
        for (right in nums.indices) {
            if (nums[right] == 0) zeroCounter++
            while (zeroCounter > 1 && left < right) if (nums[left] == 0) left++
            max = maxOf(max, right - left + 1)
        }
        return max
    }
}
