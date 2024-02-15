package problems.t2971

class Solution {
    fun largestPerimeter(nums: IntArray): Long {
        val sortedNums = nums.sortedArray()
        val prefixSum = sortedNums.runningFold(0L) { acc, value -> acc + value }.drop(1)
        var res = -1L
        for (i in 2..<sortedNums.size) {
            if (sortedNums[i] < prefixSum[i - 1]) {
                res = sortedNums[i] + prefixSum[i - 1]
            }
        }
        return res
    }
}
