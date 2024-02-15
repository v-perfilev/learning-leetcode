package problems.t1272

class Solution {
    fun removeInterval(intervals: Array<IntArray>, toBeRemoved: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        for (interval in intervals) {
            if (interval[1] <= toBeRemoved[0] || interval[0] >= toBeRemoved[1]) {
                res.add(interval.toList())
            } else {
                if (interval[0] < toBeRemoved[0]) {
                    res.add(listOf(interval[0], toBeRemoved[0]))
                }
                if (interval[1] > toBeRemoved[1]) {
                    res.add(listOf(toBeRemoved[1], interval[1]))
                }
            }
        }
        return res
    }
}
