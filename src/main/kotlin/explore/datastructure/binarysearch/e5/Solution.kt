package explore.datastructure.binarysearch.e5

class Solution {
    fun splitArray(nums: IntArray, m: Int): Int {
        var right = nums.sum()
        var left = right/m
        var mid = 0
        var ans = 0
        while(left <= right) {
            mid = left + (right - left)/2

            if(canDivide(nums, mid, m)) {
                ans = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return ans
    }

    private fun canDivide(nums: IntArray, mid: Int, m: Int) : Boolean {
        var sum = 0
        var count = 1
        for(num in nums) {
            if(num > mid) return false
            if(sum + num <= mid) {
                sum += num
            } else {
                sum = num
                count++
            }
        }
        return count <= m
    }
}
