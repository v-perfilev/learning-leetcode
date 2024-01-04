package problems.t1503

class Solution {
    fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int {
        var max = -1
        left.forEach { if (it > max) max = it }
        right.forEach { if (n - it > max) max = n - it }
        return max
    }
}
