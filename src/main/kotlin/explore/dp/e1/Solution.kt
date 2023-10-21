package explore.dp.e1

import kotlin.math.max

class Solution {
    fun rob(nums: IntArray): Int {
        val robber1 = BottomUpHouseRobber()
        val robber2 = TopDownHouseRobber()
        val result1 = robber1.rob(nums)
        val result2 = robber2.rob(nums)
        println("Result of bottom up approach: $result1")
        println("Result of top down approach: $result2")
        return result1
    }

    companion object {
        interface HouseRobber {
            fun rob(nums: IntArray): Int
        }

        class BottomUpHouseRobber : HouseRobber {
            override fun rob(nums: IntArray): Int {
                val cache = IntArray(nums.size)
                for (i in nums.indices) {
                    calcStep(nums, i, cache)
                }
                return cache[nums.size - 1]
            }

            private fun calcStep(nums: IntArray, i: Int, cache: IntArray): Int {
                when (i) {
                    0 -> cache[0] = nums[0]
                    1 -> cache[1] = max(nums[0], nums[1])
                    else -> cache[i] = max(cache[i - 2] + nums[i], cache[i - 1])
                }
                return cache[i]
            }
        }

        class TopDownHouseRobber : HouseRobber {
            override fun rob(nums: IntArray): Int {
                val cache = HashMap<Int, Int>()
                return calcStep(nums, nums.size - 1, cache)
            }

            private fun calcStep(nums: IntArray, i: Int, cache: MutableMap<Int, Int>): Int {
                if (i == 0) return nums[0]
                if (i == 1) return max(nums[0], nums[1])
                if (!cache.containsKey(i)) {
                    cache[i] = max(calcStep(nums, i - 2, cache) + nums[i], calcStep(nums, i - 1, cache))
                }
                return cache[i]!!
            }
        }
    }
}
