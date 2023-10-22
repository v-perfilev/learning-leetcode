package explore.binarysearch.e15

class Solution {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1

        while (l < r) {
            val pivot = l + (r - l) / 2
            if (nums[pivot] < nums[r]) r = pivot
            else if (nums[pivot] > nums[r]) l = pivot + 1
            else r -= 1
        }

        return nums[l]
    }
}
