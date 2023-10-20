package explore.binarysearch.e7

class Solution {
    fun findMin(nums: IntArray): Int {
        var a = 0
        var b = nums.size - 1

        while (a < b) {
            val mid = a + (b - a) / 2
            if (nums[mid] > nums.last()) a = mid + 1
            else b = mid
        }

        return nums[a]
    }
}
