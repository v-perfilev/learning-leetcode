package problems.t621

class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val taskCount = tasks.groupBy { it }.mapValues { it.value.size }
        val maxTaskCount = taskCount.values.maxOrNull()!!
        val maxTaskCountTasks = taskCount.filterValues { it == maxTaskCount }.size
        return maxOf(tasks.size, (maxTaskCount - 1) * (n + 1) + maxTaskCountTasks)
    }
}
