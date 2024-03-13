package problems.t2485

class Solution {
    fun pivotInteger(n: Int): Int {
        val totalSum = (1..n).sum()
        var runningSum = 0
        for (i in 1..n) {
            runningSum += i
            if (runningSum == totalSum - runningSum + i) {
                return i
            }
        }
        return -1
    }
}
