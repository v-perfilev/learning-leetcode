package problems.t1463

class Solution {
    private lateinit var grid: Array<IntArray>
    private lateinit var memo: Array<Array<IntArray>>
    private var rows = 0
    private var cols = 0

    fun cherryPickup(grid: Array<IntArray>): Int {
        this.rows = grid.size
        this.cols = grid.first().size
        this.grid = grid
        this.memo = Array(this.rows) { Array(this.cols) { IntArray(this.cols) { -1 } } }
        return dp(0, 0, this.cols - 1)
    }

    private fun dp(row: Int, r1: Int, r2: Int): Int {
        if (row == rows) return 0
        if (this.memo[row][r1][r2] != -1) return this.memo[row][r1][r2]

        this.memo[row][r1][r2] = grid[row][r1] + (if (r1 != r2) grid[row][r2] else 0)

        val r1Range = generateRange(r1)
        val r2Range = generateRange(r2)

        var max = Int.MIN_VALUE
        for (nextR1 in r1Range) {
            for (nextR2 in r2Range) {
                max = maxOf(
                    dp(row + 1, nextR1, nextR2),
                    max
                )
            }
        }
        this.memo[row][r1][r2] += max

        return this.memo[row][r1][r2]
    }

    private fun generateRange(r: Int): List<Int> = (r - 1..r + 1).filter { it in 0..<cols }
}
