package explore.binarysearch.e1

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var a = 0
        var b = nums.size - 1

        while (a <= b) {
            val mid = (a + b) / 2
            val value = nums[mid]
            if (value == target) return mid
            if (value < target) a = mid + 1
            if (value > target) b = mid - 1
        }

        return -1
    }
}
