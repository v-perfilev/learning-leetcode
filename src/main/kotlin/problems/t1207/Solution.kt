package problems.t1207

class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val frequencyMap = arr.toList().groupingBy { it }.eachCount()
        return frequencyMap.size == frequencyMap.values.toSet().size
    }
}
