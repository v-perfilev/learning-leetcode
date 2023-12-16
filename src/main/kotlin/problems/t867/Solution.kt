package problems.t867

class Solution {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        val height = matrix.size
        val width = matrix.first().size
        val res = Array(width) { IntArray(height) }
        for (j in 0..<height) {
            for (i in 0..<width) {
                res[i][j] = matrix[j][i]
            }
        }
        return res
    }
}
