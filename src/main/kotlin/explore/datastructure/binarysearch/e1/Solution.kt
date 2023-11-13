package explore.datastructure.binarysearch.e1

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var a = 0
        var b = nums.size - 1
        while (a <= b) {
            val m = (a + b) / 2
            if (target < nums[m]) {
                b = m - 1
            } else if (target > nums[m]) {
                a = m + 1
            } else {
                return m
            }
        }
        return a
    }
}
