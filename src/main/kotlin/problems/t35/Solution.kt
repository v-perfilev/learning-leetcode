package problems.t35

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var a = 0
        var b = nums.size
        var m = (b + a) / 2
        while (b > a && nums[m] != target) {
            if (target < nums[m]) {
                b = m - 1
                m = (b + a) / 2
            } else {
                a = m + 1
                m = (b + a) / 2
            }
        }
        return m
    }
}
