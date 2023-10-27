package explore.dp.e23

class Solution {

    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        val m = matrix.size
        val n = matrix[0].size
        val memo = matrix.clone()
        for (y in m - 2 downTo 0) {
            for (x in 0..<n) {
                val min = when (x) {
                    0 -> minOf(memo[y + 1][x], memo[y + 1][x + 1])
                    n - 1 -> minOf(memo[y + 1][x - 1], memo[y + 1][x])
                    else -> minOf(memo[y + 1][x - 1], memo[y + 1][x], memo[y + 1][x + 1])
                }
                memo[y][x] += min
            }
        }
        return memo[0].min()
    }
}
