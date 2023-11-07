package problems.t138

class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var candidate: Int? = null
        var candidateSum = 0
        var totalSum = 0
        for (i in gas.indices) {
            val sum = gas[i] - cost[i]
            totalSum += sum
            if (candidate == null || candidateSum + sum < 0) {
                if (sum >= 0) {
                    candidate = i
                    candidateSum = sum
                } else {
                    candidate = null
                    candidateSum = 0
                }
            } else {
                candidateSum += sum
            }
        }
        return if (candidate != null && totalSum >= 0) candidate else -1
    }
}
