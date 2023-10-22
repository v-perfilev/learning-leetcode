package explore.dp.e5

import kotlin.math.max

class Solution {
    fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
        val result1 = BottomUpScorer().calc(nums, multipliers)
        val result2 = TopDownScorer().calc(nums, multipliers)
        println("Bottom up result: $result1")
        println("Top down result: $result2")
        return result1
    }

    companion object {
        interface Scorer {
            fun calc(nums: IntArray, multipliers: IntArray): Int
        }

        class TopDownScorer : Scorer {
            private lateinit var nums: IntArray
            private lateinit var multipliers: IntArray
            private lateinit var cache: Array<IntArray>

            override fun calc(nums: IntArray, multipliers: IntArray): Int {
                this.nums = nums
                this.multipliers = multipliers
                this.cache = Array(multipliers.size) { IntArray(multipliers.size) }
                return dp(0, 0)
            }

            private fun dp(i: Int, l: Int): Int {
                if (i == this.multipliers.size) return 0
                val r = this.nums.size - 1 - i + l
                if (this.cache[i][l] == 0) {
                    val leftRes = this.nums[l] * this.multipliers[i] + dp(i + 1, l + 1)
                    val rightRes = this.nums[r] * this.multipliers[i] + dp(i + 1, l)
                    this.cache[i][l] = max(leftRes, rightRes)
                }
                return this.cache[i][l]
            }
        }

        class BottomUpScorer : Scorer {
            override fun calc(nums: IntArray, multipliers: IntArray): Int {
                val cache = Array(multipliers.size + 1) { IntArray(multipliers.size + 1) }
                val n = nums.size
                val m = multipliers.size

                for (i in m - 1 downTo 0) {
                    for (l in i downTo 0) {
                        val r = n - 1 - i + l
                        val leftRes = nums[l] * multipliers[i] + cache[i + 1][l + 1]
                        val rightRes = nums[r] * multipliers[i] + cache[i + 1][l]
                        cache[i][l] = max(leftRes, rightRes)
                    }
                }

                return cache[0][0]
            }
        }
    }
}
