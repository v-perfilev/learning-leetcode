package problems.t1578

class Solution {
    fun minCost(colors: String, neededTime: IntArray): Int {
        var totalTime = 0
        var currMaxTime = 0

        for (i in colors.indices) {
            if (i > 0 && colors[i] != colors[i - 1]) {
                currMaxTime = 0
            }

            totalTime += minOf(currMaxTime, neededTime[i])
            currMaxTime = maxOf(currMaxTime, neededTime[i])
        }

        return totalTime
    }
}
