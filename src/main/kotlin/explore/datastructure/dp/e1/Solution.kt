package explore.datastructure.dp.e1

class Solution {
    fun climbStairs(n: Int): Int {
        val cache = IntArray(n + 2)
        cache[0] = 0
        cache[1] = 1
        cache[2] = 2
        for (i in 3..n) cache[i] = cache[i - 1] + cache[i - 2]
        return cache[n]
    }
}
