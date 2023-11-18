package explore.datastructure.array.e5

class Solution {
    fun runningSum(nums: IntArray): IntArray {
        val arr = IntArray(nums.size)
        var sum = 0
        for (i in nums.indices) {
            sum +=nums[i]
            arr[i] = sum
        }
        return arr
    }
}
