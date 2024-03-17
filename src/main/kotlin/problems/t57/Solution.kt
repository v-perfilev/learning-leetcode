package problems.t57

class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val mergedIntervals = mutableListOf<IntArray>()
        val allIntervals = intervals.toMutableList().apply { add(newInterval) }
        allIntervals.sortBy { it[0] }
        var currentInterval = allIntervals[0]
        for (interval in allIntervals) {
            if (interval[0] <= currentInterval[1]) {
                currentInterval[1] = maxOf(currentInterval[1], interval[1])
            } else {
                mergedIntervals.add(currentInterval)
                currentInterval = interval
            }
        }
        mergedIntervals.add(currentInterval)
        return mergedIntervals.toTypedArray()
    }
}
