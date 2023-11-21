package problems.t1921

class Solution {
    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
        val stepCounts = DoubleArray(dist.size) { dist[it].toDouble() / speed[it] }
        stepCounts.sort()
        var killedCount = 0
        while (killedCount < stepCounts.size) {
            if (killedCount < stepCounts[killedCount]) killedCount++
            else break
        }
        return killedCount
    }
}
