package explore.dp.e22

import kotlin.system.measureTimeMillis

class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        // calculate top down result
        var topDownRes: Int
        val topDownTimeInMillis = measureTimeMillis {
            topDownRes = TopDownPathFinder().find(grid)
        }
        println("Top down: $topDownRes in $topDownTimeInMillis ms")

        // calculate bottom up result
        var bottomUpRes: Int
        val bottomUpTimeInMillis = measureTimeMillis {
            bottomUpRes = BottomUpPathFinder().find(grid)
        }
        println("Bottom up: $bottomUpRes in $bottomUpTimeInMillis ms")

        // return bottom up result
        return bottomUpRes
    }

    companion object {
        interface PathFinder {
            fun find(grid: Array<IntArray>): Int
        }

        /*
        TOP-DOWN
         */

        class TopDownPathFinder : PathFinder {
            private lateinit var grid: Array<IntArray>
            private var m = 0
            private var n = 0
            private lateinit var memo: Array<IntArray>

            override fun find(grid: Array<IntArray>): Int {
                this.grid = grid
                this.m = grid.size
                this.n = grid[0].size
                this.memo = Array(this.m) { IntArray(this.n) { -1 } }
                return dp(0, 0)
            }

            private fun dp(x: Int, y: Int): Int {
                if (x == this.m) return Int.MAX_VALUE
                if (y == this.n) return Int.MAX_VALUE
                if (this.memo[x][y] == -1) {
                    val nextStep = minOf(dp(x + 1, y), dp(x, y + 1))
                    val correctedNextStep = if (nextStep != Int.MAX_VALUE) nextStep else 0
                    this.memo[x][y] = this.grid[x][y] + correctedNextStep
                }
                return this.memo[x][y]
            }
        }

        /*
        BOTTOM-UP
         */

        class BottomUpPathFinder : PathFinder {
            override fun find(grid: Array<IntArray>): Int {
                val m = grid.size
                val n = grid[0].size
                val memo = Array(m) { IntArray(n) { 0 } }
                for (x in m - 1 downTo 0) {
                    for (y in n - 1 downTo 0) {
                        val xStep = if (x < m - 1) memo[x + 1][y] else Int.MAX_VALUE
                        val yStep = if (y < n - 1) memo[x][y + 1] else Int.MAX_VALUE
                        val nextStep = minOf(xStep, yStep)
                        val correctedNextStep = if (nextStep != Int.MAX_VALUE) nextStep else 0
                        memo[x][y] = grid[x][y] + correctedNextStep
                    }
                }
                return memo[0][0]
            }
        }
    }
}
