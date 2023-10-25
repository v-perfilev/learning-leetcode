package explore.dp.e16

class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        val topDownRes = TopDownCombinationCounter().change(amount, coins)
        println("Top down: $topDownRes")
        val bottomDownRes = BottomUpCombinationCounter().change(amount, coins)
        println("Bottom down: $bottomDownRes")
        return bottomDownRes
    }

    companion object {
        interface CombinationCounter {
            fun change(amount: Int, coins: IntArray): Int
        }

        /*
        TOP-DOWN
         */

        class TopDownCombinationCounter : CombinationCounter {
            private lateinit var coins: IntArray
            private lateinit var memo: Array<IntArray>

            override fun change(amount: Int, coins: IntArray): Int {
                this.coins = coins
                this.memo = Array(coins.size) { IntArray(amount + 1) { -1 } }
                return dp(0, amount)
            }

            private fun dp(coinIdx: Int, amount: Int): Int {
                if (coinIdx == this.coins.size || amount < 0) return 0
                if (amount == 0) return 1
                if (this.memo[coinIdx][amount] == -1) {
                    this.memo[coinIdx][amount] = dp(coinIdx + 1, amount) + dp(coinIdx, amount - coins[coinIdx])
                }
                return this.memo[coinIdx][amount]
            }
        }

        /*
        BOTTOM-UP
         */

        class BottomUpCombinationCounter : CombinationCounter {
            override fun change(amount: Int, coins: IntArray): Int {
                val memo = Array(coins.size + 1) { IntArray(amount + 1) }
                memo.forEach { it[0] = 1 }

                for (i in coins.size - 1 downTo 0) {
                    for (j in 1..amount) {
                        if (coins[i] > j) memo[i][j] = memo[i + 1][j]
                        else memo[i][j] = memo[i + 1][j] + memo[i][j - coins[i]]
                    }
                }

                return memo[0][amount]
            }
        }
    }
}
