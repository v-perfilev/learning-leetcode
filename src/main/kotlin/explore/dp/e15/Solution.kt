package explore.dp.e15

class Solution {
    fun numWays(n: Int, k: Int): Int {
        val topDownRes = TopDownWayCounter().numWays(n, k)
        println("Top down: $topDownRes")
        val bottomDownRes = BottomUpWayCounter().numWays(n, k)
        println("Bottom up: $bottomDownRes")
        return bottomDownRes
    }

    companion object {
        interface WayCounter {
            fun numWays(n: Int, k: Int): Int
        }

        /*
        TOP-DOWN
         */

        class TopDownWayCounter : WayCounter {
            private lateinit var memo: IntArray
            private var n = 0
            private var k = 0

            override fun numWays(n: Int, k: Int): Int {
                this.memo = IntArray(n)
                this.n = n
                this.k = k
                return dp(0)
            }

            private fun dp(i: Int): Int {
                if (i == this.n - 1) return this.k
                if (i == this.n - 2) return this.k * this.k
                if (this.memo[i] == 0) {
                    this.memo[i] = (this.k - 1) * (dp(i + 1) + dp(i + 2))
                }
                return this.memo[i]
            }
        }

        /*
        BOTTOM-UP
         */

        class BottomUpWayCounter : WayCounter {
            override fun numWays(n: Int, k: Int): Int {
                if (n == 1) return k
                if (n == 2) return k * k
                var prev2 = k
                var prev1 = k * k
                for (i in 2..<n) {
                    var tmp = prev1
                    prev1 = (k - 1) * (prev1 + prev2)
                    prev2 = tmp
                }
                return prev1
            }
        }
    }
}
