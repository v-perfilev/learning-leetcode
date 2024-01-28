package problems.t1074

class Solution {
    fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
        val rows = matrix.size
        val cols = matrix[0].size
        val prefixSumMatrix = buildPrefixSumMatrix(matrix)
        var count = 0

        for (col1 in 0..<cols) {
            for (col2 in col1..<cols) {
                val columnSum = IntArray(rows) { row -> computeSubmatrixSum(prefixSumMatrix, row, col1, row, col2) }
                count += countSubarraysWithTargetSum(columnSum, target)
            }
        }

        return count
    }

    private fun buildPrefixSumMatrix(matrix: Array<IntArray>): Array<IntArray> {
        val prefixSumMatrix = Array(matrix.size) { IntArray(matrix[0].size) }
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                prefixSumMatrix[i][j] = matrix[i][j] +
                    (if (i > 0) prefixSumMatrix[i - 1][j] else 0) +
                    (if (j > 0) prefixSumMatrix[i][j - 1] else 0) -
                    (if (i > 0 && j > 0) prefixSumMatrix[i - 1][j - 1] else 0)
            }
        }
        return prefixSumMatrix
    }

    private fun computeSubmatrixSum(
        prefixSumMatrix: Array<IntArray>,
        row1: Int,
        col1: Int,
        row2: Int,
        col2: Int
    ): Int {
        return prefixSumMatrix[row2][col2] -
            (if (row1 > 0) prefixSumMatrix[row1 - 1][col2] else 0) -
            (if (col1 > 0) prefixSumMatrix[row2][col1 - 1] else 0) +
            (if (row1 > 0 && col1 > 0) prefixSumMatrix[row1 - 1][col1 - 1] else 0)
    }

    private fun countSubarraysWithTargetSum(arr: IntArray, target: Int): Int {
        var count = 0
        var currentSum = 0
        val prefixSumCount = mutableMapOf(0 to 1)

        for (num in arr) {
            currentSum += num
            count += prefixSumCount.getOrDefault(currentSum - target, 0)
            prefixSumCount[currentSum] = prefixSumCount.getOrDefault(currentSum, 0) + 1
        }

        return count
    }
}
