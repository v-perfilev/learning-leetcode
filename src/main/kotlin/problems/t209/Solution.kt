package problems.t209

class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var result = Int.MAX_VALUE
        var sum = 0
        var i = 0
        var j = 0
        while (i < nums.size && j < nums.size) {
            sum += nums[j]

            while (sum >= target) {
                if (result > j - i + 1) result = j - i + 1
                sum -= nums[i]
                i++
            }

            j++
        }
        return if (result == Int.MAX_VALUE) 0 else result
    }
}
