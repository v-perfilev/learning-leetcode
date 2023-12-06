package explore.datastructure.hashtable.e2

class Solution {
    fun missingNumber(nums: IntArray): Int {
        val memo = BooleanArray(nums.size + 1)
        nums.forEach { memo[it] = true }
        for (i in memo.indices) {
            if (!memo[i]) return i
        }
        return -1
    }
}
