package problems.t15

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val res = mutableListOf<List<Int>>()
        var i = 0
        while (i < nums.size - 2 && nums[i] <= 0) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSums(nums, res, i)
            }
            i++
        }
        return res
    }

    private fun twoSums(nums: IntArray, res: MutableList<List<Int>>, i: Int) {
        var l = i + 1
        var r = nums.size - 1
        while (l < r) {
            val sum = nums[l] + nums[r]
            if (sum == -nums[i]) {
                res.add(listOf(nums[i], nums[l], nums[r]))
                while (l < r && nums[r] == nums[r - 1]) r--
                while (l < r && nums[l] == nums[l + 1]) l++
                r--
                l++
            } else if (sum > -nums[i]) r--
            else l++
        }
    }

    private fun twoSumsHashMap(nums: IntArray, res: MutableSet<List<Int>>, i: Int) {
        val set = mutableSetOf<Int>()
        for (j in i + 1..<nums.size) {
            if (-nums[i] - nums[j] in set) {
                res.add(listOf(nums[i], -nums[i] - nums[j], nums[j]))
            }
            set.add(nums[j])
        }
    }
}
