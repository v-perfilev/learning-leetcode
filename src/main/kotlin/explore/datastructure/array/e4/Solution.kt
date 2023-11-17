package explore.datastructure.array.e4

class Solution {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var zeros = 0
        var max = 0
        var left = 0
        for (right in nums.indices) {
            if (nums[right] == 0) zeros++
            while (zeros > k) {
                if (nums[left] == 0) zeros--
                left++
            }
            max = maxOf(max, right - left + 1)
        }
        return max
    }
}
