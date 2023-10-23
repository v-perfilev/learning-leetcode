package explore.dp.e9

import kotlin.math.min

class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val brutForceRes = BrutForceCoinChangeFinder().findMinCount(coins, amount)
        println("Brut force: $brutForceRes")
        val topDownRes = TopDownCoinChangeFinder().findMinCount(coins, amount)
        println("Top down: $topDownRes")
        val bottomUpRes = BottomUpCoinChangeFinder().findMinCount(coins, amount)
        println("Bottom up: $bottomUpRes")
        return bottomUpRes
    }

    companion object {
        interface CoinChangeFinder {
            fun findMinCount(coins: IntArray, amount: Int): Int
        }

        class BrutForceCoinChangeFinder : CoinChangeFinder {
            override fun findMinCount(coins: IntArray, amount: Int): Int {
                val res = findMinCount(coins, amount, 0)
                return if (res == Int.MAX_VALUE) -1 else res
            }

            private fun findMinCount(coins: IntArray, amount: Int, step: Int): Int {
                if (amount < 0) return Int.MAX_VALUE
                if (amount == 0) return step
                return coins.map { findMinCount(coins, amount - it, step + 1) }.min()
            }
        }

        class TopDownCoinChangeFinder : CoinChangeFinder {
            override fun findMinCount(coins: IntArray, amount: Int): Int {
                val cache = IntArray(amount + 1) { Int.MAX_VALUE }
                return findMinCount(coins, amount, cache)
            }

            private fun findMinCount(coins: IntArray, amount: Int, cache: IntArray): Int {
                if (amount < 0) return -1
                if (amount == 0) return 0
                if (cache[amount] == Int.MAX_VALUE) {
                    var min = Int.MAX_VALUE
                    coins.forEach {
                        val result = findMinCount(coins, amount - it, cache)
                        if (result in 0..<min) min = result + 1
                    }
                    cache[amount] = if (min == Int.MAX_VALUE) -1 else min
                }
                return cache[amount]
            }
        }

        class BottomUpCoinChangeFinder : CoinChangeFinder {
            override fun findMinCount(coins: IntArray, amount: Int): Int {
                val cache = IntArray(amount + 1) { Int.MAX_VALUE / 2 }
                cache[0] = 0
                for (i in 1..amount) {
                    coins.forEach {
                        if (it <= i) {
                            cache[i] = min(cache[i], cache[i - it] + 1)
                        }
                    }
                }
                return if (cache[amount] == Int.MAX_VALUE / 2) -1 else cache[amount]
            }
        }
    }
}
