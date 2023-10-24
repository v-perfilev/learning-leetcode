package explore.dp.e11

import kotlin.math.max

class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val bottomUpRes = BottomUpLISFinder().find(nums)
        println("Bottom up: $bottomUpRes")
        val topDownRes = TopDownLISFinder().find(nums)
        println("Top down: $topDownRes")
        return topDownRes
    }

    companion object {
        interface LISFinder {
            fun find(nums: IntArray): Int
        }

        /*
        BOTTOM-UP
         */

        class BottomUpLISFinder : LISFinder {
            override fun find(nums: IntArray): Int {
                val dp = IntArray(nums.size) { 1 }

                for (i in 1..<nums.size) {
                    for (j in 0..<i) {
                        if (nums[i] > nums[j]) {
                            dp[i] = max(dp[i], dp[j] + 1)
                        }
                    }
                }

                return dp.max()
            }
        }

        /*
        TOP-DOWN
         */

        class TopDownLISFinder : LISFinder {
            override fun find(nums: IntArray): Int {
                val cache = IntArray(nums.size) { -1 }
                dp(nums, cache, nums.size - 1)
                return cache.max()
            }

            private fun dp(nums: IntArray, cache: IntArray, i: Int) {
                if (cache[i] == -1) {
                    cache[i] = 1
                    for (j in i - 1 downTo 0) {
                        dp(nums, cache, j)
                        if (nums[i] > nums[j]) {
                            cache[i] = max(cache[i], cache[j] + 1)
                        }
                    }
                }
            }
        }
    }
}
