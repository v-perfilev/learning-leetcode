package explore.dp.e7

import kotlin.math.max

class Solution {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val result1 = TopDownSquareFinder().find(matrix)
        val result2 = BottomUpSquareFinder().find(matrix)
        println("Top down result: $result1")
        println("Bottom up result: $result2")
        return result1
    }

    companion object {
        interface SquareFinder {
            fun find(matrix: Array<CharArray>): Int
        }

        class TopDownSquareFinder : SquareFinder {
            private lateinit var matrix: Array<CharArray>
            private lateinit var cache: Array<IntArray>
            private var height = 0
            private var width = 0
            private var maxWidth = 0

            override fun find(matrix: Array<CharArray>): Int {
                this.height = matrix.size
                this.width = matrix[0].size
                this.matrix = matrix
                this.cache = Array(this.height) { IntArray(this.width) { -1 } }
                this.maxWidth = 0
                dp(0, 0)
                return this.maxWidth * this.maxWidth
            }

            private fun dp(i: Int, j: Int): Int {
                if (i >= this.height || j >= this.width) return 0
                if (this.cache[i][j] == -1) {
                    val minAdjacentSquare = minOf(dp(i, j + 1), dp(i + 1, j), dp(i + 1, j + 1))
                    this.cache[i][j] = if (this.matrix[i][j] == '1') minAdjacentSquare + 1 else 0
                    this.maxWidth = max(this.maxWidth, this.cache[i][j])
                }
                return this.cache[i][j]
            }
        }

        class BottomUpSquareFinder : SquareFinder {
            override fun find(matrix: Array<CharArray>): Int {
                val height = matrix.size
                val width = matrix[0].size
                val cache = Array(height + 1) { IntArray(width + 1) }
                var maxWidth = 0
                for (i in height - 1 downTo 0) {
                    for (j in width - 1 downTo 0) {
                        val minAdjacentSquare = minOf(cache[i][j + 1], cache[i + 1][j], cache[i + 1][j + 1])
                        cache[i][j] = if (matrix[i][j] == '1') minAdjacentSquare + 1 else 0
                        maxWidth = max(maxWidth, cache[i][j])
                    }
                }
                return maxWidth * maxWidth
            }
        }
    }
}
