package explore.binarysearch.e8

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) return intArrayOf(-1, -1)
        val first = search(nums, target, true)
        if (first == -1) return intArrayOf(-1, -1)
        val last = search(nums, target, false)
        return intArrayOf(first, last)
    }

    private fun search(nums: IntArray, target: Int, isLeft: Boolean): Int {
        var a = 0
        var b = nums.size - 1
        while (a <= b) {
            val mid = a + (b - a) / 2
            if (nums[mid] == target) {
                if (isLeft) {
                    if (mid == a || nums[mid - 1] != target) return mid
                    b = mid - 1
                } else {
                    if (mid == b || nums[mid + 1] != target) return mid
                    a = mid + 1
                }
            } else if (nums[mid] > target) b = mid - 1
            else a = mid + 1
        }
        return -1
    }
}
