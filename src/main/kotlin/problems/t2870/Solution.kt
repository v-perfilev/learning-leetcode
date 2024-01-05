package problems.t2870

class Solution {
    fun minOperations(nums: IntArray): Int {
        val countMap = nums.toList().groupingBy { it }.eachCount()
        var res = 0
        for (value in countMap.values) {
            val count = countOperations(value)
            if (count == -1) return -1
            res += count
        }
        return res
    }

    private fun countOperations(value: Int): Int {
        var rest = value
        var count = 0
        while (rest > 5) {
            rest -= 3
            count++
        }
        if (rest % 3 == 0) return count + rest / 3
        if (rest % 2 == 0) return count + rest / 2
        if (rest % 3 == 2) return count + rest / 3 + 1
        return -1
    }
}
