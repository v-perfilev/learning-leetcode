package explore.dp.e20

import kotlin.system.measureTimeMillis

class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        // calculate top down result
        var topDownRes: Int
        val topDownTimeInMillis = measureTimeMillis {
            topDownRes = TopDownPathFinder().find(m, n)
        }
        println("Top down: $topDownRes in $topDownTimeInMillis ms")

        // calculate bottom up result
        var bottomUpRes: Int
        val bottomUpTimeInMillis = measureTimeMillis {
            bottomUpRes = BottomUpPathFinder().find(m, n)
        }
        println("Bottom up: $bottomUpRes in $bottomUpTimeInMillis ms")

        // return bottom up result
        return bottomUpRes
    }

    companion object {
        interface PathFinder {
            fun find(m: Int, n: Int): Int
        }

        /*
        TOP-DOWN
         */

        class TopDownPathFinder : PathFinder {
            private var m = 0
            private var n = 0
            private lateinit var memo: Array<IntArray>

            override fun find(m: Int, n: Int): Int {
                this.m = m
                this.n = n
                this.memo = Array(m) { IntArray(n) { -1 } }
                this.memo[m - 1][n - 1] = 1
                return dp(0, 0)
            }

            private fun dp(x: Int, y: Int): Int {
                if (x == m) return 0
                if (y == n) return 0
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
            override fun find(m: Int, n: Int): Int {
                val memo = Array(m) { IntArray(n) }
                memo[m - 1][n - 1] = 1
                for (x in m - 1 downTo 0) {
                    for (y in n - 1 downTo 0) {
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
