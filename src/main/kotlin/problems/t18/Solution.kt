package problems.t18

class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val sorted = nums.sortedArray()
        val result = mutableListOf<List<Int>>()
        for (i in 0..sorted.size - 4) {
            if (i > 0 && sorted[i] == sorted[i - 1]) continue
            for (j in i + 1..sorted.size - 3) {
                if (j > i + 1 && sorted[j] == sorted[j - 1]) continue
                twoSum(sorted, result, target, i, j)
            }
        }
        return result
    }

    private fun twoSum(sorted: IntArray, result: MutableList<List<Int>>, target: Int, i: Int, j: Int) {
        var l = j + 1
        var r = sorted.size - 1
        while (l < r) {
            val sum = sorted[i].toLong() + sorted[j].toLong() + sorted[l].toLong() + sorted[r].toLong()
            if (sum < target) l++
            else if (sum > target) r--
            else {
                result.add(listOf(sorted[i], sorted[j], sorted[l], sorted[r]))
                while (sorted[l + 1] == sorted[l] && l + 1 < r) l++
                while (sorted[r - 1] == sorted[r] && l < r - 1) r--
                l++
                r--
            }
        }
    }
}
