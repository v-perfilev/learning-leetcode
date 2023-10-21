package explore.dp.e2

import kotlin.math.min

class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val result1 = BottomUpStairsClimber().minCost(cost)
        val result2 = TopDownStairsClimber().minCost(cost)
        println("Bottom up result: $result1")
        println("Top down result: $result2")
        return result1
    }

    companion object {
        interface StairsClimber {
            fun minCost(cost: IntArray): Int
        }

        class BottomUpStairsClimber : StairsClimber {
            override fun minCost(cost: IntArray): Int {
                if (cost.size == 1) return cost[0]
                val cache = IntArray(cost.size)
                cache[0] = cost[0]
                cache[1] = cost[1]
                for (i in 2..<cost.size) {
                    cache[i] = min(cache[i - 1], cache[i - 2]) + cost[i]
                }
                return min(cache[cache.size - 1], cache[cache.size - 2])
            }
        }

        class TopDownStairsClimber : StairsClimber {
            override fun minCost(cost: IntArray): Int {
                if (cost.size == 1) return cost[0]
                val cache = HashMap<Int, Int>()
                val lastStairCost = getStairCost(cost, cost.size - 1, cache)
                val penultimateStairCost = getStairCost(cost, cost.size - 2, cache)
                return min(lastStairCost, penultimateStairCost)
            }

            private fun getStairCost(cost: IntArray, i: Int, cache: MutableMap<Int, Int>): Int {
                if (!cache.containsKey(i)) {
                    if (i == 0 || i == 1) cache[i] = cost[i]
                    else cache[i] = min(getStairCost(cost, i - 1, cache), getStairCost(cost, i - 2, cache)) + cost[i]
                }
                return cache[i]!!
            }
        }
    }
}
