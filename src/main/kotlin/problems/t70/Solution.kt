package problems.t70

class Solution {
    fun climbStairs(n: Int): Int {
        if (n <= 1) return 1
        val cache = IntArray(n + 1)
        cache[0] = 0
        cache[1] = 1
        cache[2] = 2
        for (i in 3..n) {
            cache[i] = cache[i - 1] + cache[i - 2]
        }
        return cache[n]
    }
}
