package problems.t1814

class Solution {
    companion object {
        const val MOD = 1e9 + 7
    }

    fun countNicePairs(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        var res = 0
        nums.forEach { num ->
            val pointer = num - rev(num)
            val cur = map.getOrDefault(pointer, 0)
            res = ((res + cur) % MOD).toInt()
            map[pointer] = cur + 1
        }
        return res
    }

    private fun rev(num: Int): Int = num.toString().reversed().toInt()
}
