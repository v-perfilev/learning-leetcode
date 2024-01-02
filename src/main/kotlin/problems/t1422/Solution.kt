package problems.t1422

class Solution {
    fun maxScore(s: String): Int {
        val prefixSum = s.runningFold(0) { acc, c -> acc + c.code - 48 }.drop(1)
        return prefixSum.dropLast(1).mapIndexed { index, v -> index + prefixSum.last() + 1 - 2 * v }.max()
    }
}
