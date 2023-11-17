package explore.datastructure.array.e3

class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var sum = 0.0
        repeat(k) { i -> sum += nums[i] }
        var max = sum / k
        for (i in k..<nums.size) {
            sum -= nums[i - k]
            sum += nums[i]
            max = maxOf(max, sum / k)
        }
        return max
    }
}
