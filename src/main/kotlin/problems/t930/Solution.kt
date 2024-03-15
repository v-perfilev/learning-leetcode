package problems.t930

class Solution {
    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
        val count = mutableMapOf(0 to 1)
        var sum = 0
        var result = 0

        for (num in nums) {
            sum += num
            result += count.getOrDefault(sum - goal, 0)
            count[sum] = count.getOrDefault(sum, 0) + 1
        }

        return result
    }
}
