package problems.t1235

class Solution {
    private lateinit var jobMap: Map<Int, List<Job>>
    private lateinit var startTimes: List<Int>
    private lateinit var memo: IntArray

    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        this.jobMap = startTime.indices
            .map { Job(startTime[it], endTime[it], profit[it]) }
            .groupBy { it.startTime }
        this.startTimes = this.jobMap.keys.sorted()
        this.memo = IntArray(this.jobMap.size) { -1 }
        return dp(0)
    }

    private fun dp(i: Int): Int {
        if (i >= startTimes.size) return 0
        if (memo[i] != -1) return memo[i]
        val time = startTimes[i]
        val jobMax = jobMap[time]!!.map { it.profit + dp(findNextIndex(it.endTime)) }.max()
        val skipMax = dp(i + 1)
        memo[i] = maxOf(jobMax, skipMax)
        return memo[i]
    }

    private fun findNextIndex(time: Int): Int {
        this.startTimes.binarySearch(time).let {
            return if (it >= 0) it else -it - 1
        }
    }

    data class Job(val startTime: Int, val endTime: Int, val profit: Int)
}
