package explore.binarysearch.e6

class Solution {
    fun findPeakElement(nums: IntArray): Int {
        var a = 0
        var b = nums.size - 1

        while (a < b) {
            val mid = a + (b - a) / 2
            if (nums[mid] < nums[b]) a = mid + 1
            else b = mid
        }

        return a
    }
}
