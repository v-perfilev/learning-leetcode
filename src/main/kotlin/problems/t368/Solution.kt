package problems.t368

class Solution {
    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        if (nums.size == 1) return listOf(nums[0])

        nums.sort()
        val dp = IntArray(nums.size) { 1 }
        var max = 0
        var maxIndex = 0
        for (i in 1 until nums.size) {
            for (j in 0 until i) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
            if (dp[i] > max) {
                max = dp[i]
                maxIndex = i
            }
        }
        val result = mutableListOf<Int>()
        var prev = nums[maxIndex]
        for (i in maxIndex downTo 0) {
            if (prev % nums[i] == 0 && dp[i] == max) {
                result.add(nums[i])
                prev = nums[i]
                max--
            }
        }
        return result
    }
}
