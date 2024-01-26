package problems.t576

class Solution {
    private lateinit var memo: Array<Array<IntArray>>
    private var m = 0
    private var n = 0

    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        this.memo = Array(m) { Array(n) { IntArray(maxMove + 1) { -1 } } }
        this.m = m
        this.n = n
        return dp(startRow, startColumn, maxMove)
    }

    private fun dp(row: Int, col: Int, move: Int): Int {
        if (row !in 0..<m || col !in 0..<n) return 1
        if (move == 0) return 0
        if (memo[row][col][move] != -1) return memo[row][col][move]

        memo[row][col][move] = 0
        directions.forEach { (dy, dx) ->
            memo[row][col][move] = (memo[row][col][move] + dp(row + dy, col + dx, move - 1)) % MOD
        }

        return memo[row][col][move]
    }

    companion object {
        private val directions = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(0, 1),
        )

        private const val MOD = 1e9.toInt() + 7
    }
}
