package explore.dp.e19

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        var curMax = 0
        var curMin = 0
        var maxSum = nums[0]
        var minSum = nums[0]
        var totalSum = 0

        for (num in nums) {
            curMax = max(curMax, 0) + num
            maxSum = max(maxSum, curMax)

            curMin = min(curMin, 0) + num
            minSum = min(minSum, curMin)
            totalSum += num
        }

        return if (totalSum == minSum) {
            maxSum
        } else max(maxSum, totalSum - minSum)
    }

}
