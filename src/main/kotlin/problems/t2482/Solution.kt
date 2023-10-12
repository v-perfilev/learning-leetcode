package problems.t2482

class Solution {
    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
        val n = grid.size
        val m = grid.first().size
        val onesRowCount = Array(n) { grid[it].sum() }
        val onesColCount = Array(m) { grid.map { v -> v[it] }.sum() }
        val res = Array(n) { IntArray(m) }
        for (j in 0..<n) {
            val row = 2 * onesRowCount[j] - n
            for (i in 0..<m) {
                val col = 2 * onesColCount[i] - m
                res[j][i] = row + col
            }
        }
        return res
    }
}
