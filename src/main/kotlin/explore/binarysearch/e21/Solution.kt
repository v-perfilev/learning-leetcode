package explore.binarysearch.e21

class Solution {
    fun smallestDistancePair(nums: IntArray, k: Int): Int {
        nums.sort()
        var lo = 0
        var hi = nums[nums.size - 1] - nums[0]
        while (lo < hi) {
            val mi = (lo + hi) / 2
            var count = 0
            var left = 0
            for (right in nums.indices) {
                while (nums[right] - nums[left] > mi) left++
                count += right - left
            }
            if (count >= k) hi = mi else lo = mi + 1
        }
        return lo
    }
}
