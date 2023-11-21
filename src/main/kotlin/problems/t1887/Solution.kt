package problems.t1887

class Solution {
    fun reductionOperations(nums: IntArray): Int {
        val sorted = nums.sorted()
        var totalOperationCount = 0
        var currentStepOperationCount = 0
        for (i in 1..<sorted.size) {
            if (sorted[i] != sorted[i - 1]) currentStepOperationCount++
            totalOperationCount += currentStepOperationCount
        }
        return totalOperationCount
    }
}
