package explore.datastructure.bonus.e3

class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val resultList = ArrayDeque<IntArray>()
        val sourceList = ArrayList<IntArray>()
            .apply {
                addAll(intervals)
                add(newInterval)
            }
            .sortedWith { a, b -> a[0].compareTo(b[0]) }
        sourceList.forEach { interval ->
            val (start, end) = interval
            if (resultList.isNotEmpty() && start <= resultList.last()[1]) {
                resultList.last()[1] = maxOf(resultList.last()[1], end)
            } else {
                resultList.addLast(interval)
            }
        }
        return resultList.toTypedArray()
    }
}
