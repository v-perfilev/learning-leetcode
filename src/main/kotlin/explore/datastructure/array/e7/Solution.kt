package explore.datastructure.array.e7

class Solution {
    fun getAverages(nums: IntArray, k: Int): IntArray {
        if (k == 0) return nums
        val runningSums = LongArray(nums.size) { nums[it].toLong() }
        for (i in 1..<runningSums.size) runningSums[i] = runningSums[i - 1] + runningSums[i]
        val res = IntArray(runningSums.size) { -1 }
        for (i in k..<runningSums.size - k) {
            val sum = runningSums[i + k] - runningSums[i - k] + nums[i - k]
            res[i] = (sum / (k * 2 + 1)).toInt()
        }
        return res
    }
}
