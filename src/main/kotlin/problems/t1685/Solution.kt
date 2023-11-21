package problems.t1685

class Solution {
    fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
        val prefixSum = nums.runningFold(0) { sum, num -> sum + num }
        val suffixSum = nums.runningFold(prefixSum.last()) { sum, num -> sum - num }
        return nums.mapIndexed { i, num ->
            val leftSum = if (i > 0) prefixSum[i] else 0
            val left = num * i - leftSum
            val rightSum = if (i < nums.size - 1) suffixSum[i + 1] else 0
            val right = rightSum - num * (nums.size - i - 1)
            left + right
        }.toIntArray()
    }
}
