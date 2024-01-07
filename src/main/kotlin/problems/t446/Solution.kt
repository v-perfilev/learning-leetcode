package problems.t446

class Solution {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        val n = nums.size
        var totalCount = 0
        val dp = Array(n) { HashMap<Long, Int>() }

        for (j in 1..<n) {
            for (i in 0..<j) {
                val diff = nums[j].toLong() - nums[i].toLong()
                val countAtI = dp[i].getOrDefault(diff, 0)
                dp[j][diff] = dp[j].getOrDefault(diff, 0) + countAtI + 1
                totalCount += countAtI
            }
        }

        return totalCount
    }
}
