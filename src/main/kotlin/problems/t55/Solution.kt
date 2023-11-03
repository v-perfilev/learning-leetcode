package problems.t55

class Solution {
    fun jump(nums: IntArray): Int {
        var position = 0
        var jumps = 0

        for (i in 0..<nums.size - 1) {
            val distance = i + nums[i]
            if (distance > position) {
                position = distance
                jumps++
            }

            if (distance >= nums.size - 1) {
                break
            }
        }

        return jumps
    }
}
