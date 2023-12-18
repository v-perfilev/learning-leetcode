package problems.t1099

class Solution {
    fun twoSumLessThanK(nums: IntArray, k: Int): Int {
        val sortedArr = nums.sortedArray()
        var max = -1
        var left = 0
        var right = sortedArr.size - 1
        while (left < right) {
            val sum = sortedArr[left] + sortedArr[right]
            if (sum >= k) right--
            else {
                max = maxOf(max, sum)
                left++
            }
        }
        return max
    }
}
