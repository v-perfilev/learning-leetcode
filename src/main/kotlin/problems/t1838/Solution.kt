package problems.t1838

class Solution {
    fun maxFrequency(nums: IntArray, k: Int): Int {
        val arr = nums.sortedArray()
        var max = 0
        var sum = 0
        var left = 0
        for (right in arr.indices) {
            sum += arr[right]
            while (left < right && arr[right] * (right - left + 1) - sum > k) sum -= arr[left++]
            max = maxOf(max, right - left + 1)
        }
        return max
    }
}
