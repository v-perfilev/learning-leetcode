package explore.dp.e21

import kotlin.system.measureTimeMillis

class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        // calculate top down result
        var topDownRes: Int
        val topDownTimeInMillis = measureTimeMillis {
            topDownRes = TopDownPathFinder().find(obstacleGrid)
        }
        println("Top down: $topDownRes in $topDownTimeInMillis ms")

        // calculate bottom up result
        var bottomUpRes: Int
        val bottomUpTimeInMillis = measureTimeMillis {
            bottomUpRes = BottomUpPathFinder().find(obstacleGrid)
        }
        println("Bottom up: $bottomUpRes in $bottomUpTimeInMillis ms")

        // return bottom up result
        return bottomUpRes
    }

    companion object {
        interface PathFinder {
            fun find(obstacleGrid: Array<IntArray>): Int
        }

        /*
        TOP-DOWN
         */

        class TopDownPathFinder : PathFinder {
            private lateinit var obstacleGrid: Array<IntArray>
            private var m = 0
            private var n = 0
            private lateinit var memo: Array<IntArray>

            override fun find(obstacleGrid: Array<IntArray>): Int {
                if (obstacleGrid.last().last() == 1) return 0
                this.obstacleGrid = obstacleGrid
                this.m = obstacleGrid.size
                this.n = obstacleGrid[0].size
                this.memo = Array(this.m) { IntArray(this.n) { -1 } }
                this.memo[this.m - 1][this.n - 1] = 1
                return dp(0, 0)
            }

            private fun dp(x: Int, y: Int): Int {
                if (x == this.m) return 0
                if (y == this.n) return 0
                if (this.obstacleGrid[x][y] == 1) return 0
                if (this.memo[x][y] == -1) {
                    this.memo[x][y] = dp(x + 1, y) + dp(x, y + 1)
                }
                return this.memo[x][y]
            }
        }

        /*
        BOTTOM-UP
         */

        class BottomUpPathFinder : PathFinder {
            override fun find(obstacleGrid: Array<IntArray>): Int {
                if (obstacleGrid.last().last() == 1) return 0
                val m = obstacleGrid.size
                val n = obstacleGrid[0].size
                val memo = Array(m) { IntArray(n) }
                memo[m - 1][n - 1] = 1
                for (x in m - 1 downTo 0) {
                    for (y in n - 1 downTo 0) {
                        if (obstacleGrid[x][y] == 1) continue
                        if (x < m - 1) {
                            memo[x][y] += memo[x + 1][y]
                        }
                        if (y < n - 1) {
                            memo[x][y] += memo[x][y + 1]
                        }
                    }
                }
                return memo[0][0]
            }
        }
    }
}
