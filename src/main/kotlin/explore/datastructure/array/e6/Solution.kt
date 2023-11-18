package explore.datastructure.array.e6

class Solution {
    fun minStartValue(nums: IntArray): Int {
        val runningSums = IntArray(nums.size) { nums[it] }
        for (i in 1..<nums.size) runningSums[i] = runningSums[i - 1] + runningSums[i]
        val min = runningSums.min()
        return if (min < 1) 1 - min else 1
    }
}
