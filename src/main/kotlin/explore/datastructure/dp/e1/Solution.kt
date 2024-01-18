package explore.datastructure.dp.e1

class Solution {
    fun climbStairs(n: Int): Int {
        if (n <= 1) return 1
        var perultimate = 1
        var previous = 2
        for (i in 3..n) {
            val tmp = previous
            previous += perultimate
            perultimate = tmp
        }
        return previous
    }
}
