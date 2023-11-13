package explore.datastructure.binarysearch.e3

import kotlin.math.ceil

class Solution {
    fun smallestDivisor(nums: IntArray, threshold: Int): Int {
        var left = 1
        var right = 1e3.toInt()
        while (left < right) {
            val mid = left + (right - left) / 2
            val divisionSum = calcDivisionSum(nums, mid)
            if (divisionSum <= threshold) right = mid
            else left = mid + 1
        }
        return left
    }

    private fun calcDivisionSum(nums: IntArray, divider: Int): Int =
        nums.map { ceil(it.toFloat() / divider) }.sumOf { it.toInt() }
}
