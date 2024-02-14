package problems.t2149

class Solution {
    fun rearrangeArray(nums: IntArray): IntArray {
        val res = IntArray(nums.size)
        var positive = -1
        var negative = -1
        for (i in res.indices) {
            if (i % 2 == 0) {
                positive++
                while (nums[positive] < 0) positive++
                res[i] = nums[positive]
            } else {
                negative++
                while (nums[negative] >= 0) negative++
                res[i] = nums[negative]
            }
        }
        return res
    }
}
