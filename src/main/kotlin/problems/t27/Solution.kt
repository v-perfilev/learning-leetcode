package problems.t27

class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var pointer = 0
        nums.forEach { if (it != `val`) nums[pointer++] = it }
        return pointer
    }
}
