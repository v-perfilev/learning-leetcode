package problems.t268

class Solution {
    fun missingNumber(nums: IntArray): Int {
        val set = nums.toSet()
        if (!set.contains(set.size - 1)) return set.size - 1
        for (i in 0..set.size) {
            if (!set.contains(i)) return i
        }
        throw Exception("No missing number found")
    }
}
