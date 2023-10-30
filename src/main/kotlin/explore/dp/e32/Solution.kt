package explore.dp.e32

import kotlin.system.measureTimeMillis

class Solution {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        // calculate top down result
        var topDownRes: Int
        val topDownTimeInMillis = measureTimeMillis {
            topDownRes = TopDownMinCostCalculator().findMin(days, costs)
        }
        println("Top down: $topDownRes in $topDownTimeInMillis ms")

        // calculate bottom up result
        var bottomUpRes: Int
        val bottomUpTimeInMillis = measureTimeMillis {
            bottomUpRes = BottomUpMinCostCalculator().findMin(days, costs)
        }
        println("Bottom up: $bottomUpRes in $bottomUpTimeInMillis ms")

        // return bottom up result
        return bottomUpRes
    }

    companion object {
        interface MinCostCalculator {
            fun findMin(days: IntArray, costs: IntArray): Int
        }

        class TopDownMinCostCalculator : MinCostCalculator {
            private lateinit var days: IntArray
            private lateinit var costs: IntArray
            private lateinit var memo: IntArray

            override fun findMin(days: IntArray, costs: IntArray): Int {
                this.days = days
                this.costs = costs
                this.memo = IntArray(days.size) { -1 }
                return dp(0)
            }

            private fun dp(day: Int): Int {
                if (day >= this.days.size) return 0
                if (this.memo[day] == -1) {
                    val cost0 = this.costs[0] + dp(findNextDay(day, 1))
                    val cost1 = this.costs[1] + dp(findNextDay(day, 7))
                    val cost2 = this.costs[2] + dp(findNextDay(day, 30))
                    this.memo[day] = minOf(cost0, cost1, cost2)
                }
                return this.memo[day]
            }

            private fun findNextDay(day: Int, duration: Int): Int {
                var nextDay = day + 1
                while (nextDay < this.days.size && this.days[nextDay] - this.days[day] < duration) nextDay++
                return nextDay
            }
        }

        class BottomUpMinCostCalculator : MinCostCalculator {
            override fun findMin(days: IntArray, costs: IntArray): Int {
                val memo = IntArray(days.size + 1) { if (it == days.size) 0 else -1 }
                for (day in days.indices.reversed()) {
                    val cost0NextDay = findNextDay(days, day, 1)
                    val cost0 = costs[0] + memo[cost0NextDay]
                    val cost1NextDay = findNextDay(days, day, 7)
                    val cost1 = costs[1] + memo[cost1NextDay]
                    val cost2NextDay = findNextDay(days, day, 30)
                    val cost2 = costs[2] + memo[cost2NextDay]
                    memo[day] = minOf(cost0, cost1, cost2)
                }
                return memo[0]
            }

            private fun findNextDay(days: IntArray, day: Int, duration: Int): Int {
                var nextDay = day + 1
                while (nextDay < days.size && days[nextDay] - days[day] < duration) nextDay++
                return nextDay
            }
        }
    }
}
