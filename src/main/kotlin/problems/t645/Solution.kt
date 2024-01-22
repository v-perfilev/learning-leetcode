package problems.t645

class Solution {
    fun findErrorNums(nums: IntArray): IntArray {
        val mask = IntArray(nums.size)
        nums.forEach { mask[it - 1]++ }
        val res = IntArray(2)
        mask.forEachIndexed { index, value ->
            if (value == 2) res[0] = index + 1
            else if (value == 0) res[1] = index + 1
        }
        return res
    }
}
