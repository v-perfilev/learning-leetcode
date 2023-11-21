package problems.t1630

class Solution {
    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
        val resList = mutableListOf<Boolean>()
        for (i in l.indices) {
            resList.add(checkOneSubarray(nums, l[i], r[i]))
        }
        return resList
    }

    private fun checkOneSubarray(nums: IntArray, start: Int, end: Int): Boolean {
        val numSet = nums.filterIndexed { index, _ -> index in start..end }.toSet()
        val length = end - start + 1
        val delta = (numSet.max() - numSet.min()) / (length - 1)
        if (numSet.min() + (length - 1) * delta != numSet.max()) return false
        val refSet = IntArray(length) { numSet.min() + it * delta }.toSet()
        return numSet.containsAll(refSet)
    }
}
