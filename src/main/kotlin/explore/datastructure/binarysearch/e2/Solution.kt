package explore.datastructure.binarysearch.e2

class Solution {
    fun answerQueries(nums: IntArray, queries: IntArray): IntArray {
        val prefixSums = nums.sorted().runningFold(0) { sum, num -> sum + num }.toIntArray()
        return queries.map { binarySearch(prefixSums, it) }.toIntArray()
    }

    private fun binarySearch(arr: IntArray, value: Int): Int {
        var left = 0
        var right = arr.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (arr[mid] == value) return mid
            else if (arr[mid] > value) right = mid - 1
            else left = mid + 1
        }
        return left - 1
    }
}
