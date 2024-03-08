package problems.t3005

class Solution {
    fun maxFrequencyElements(nums: IntArray): Int {
        val counts = nums.toList().groupingBy { it }.eachCount().values
        val max = counts.max()
        return counts.count { it == max } * max
    }
}
