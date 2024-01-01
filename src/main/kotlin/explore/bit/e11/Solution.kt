package explore.bit.e11

class Solution {
    fun singleNumber(nums: IntArray): IntArray {
        var bitmask = 0
        for (num in nums) bitmask = bitmask xor num
        val diff = bitmask and -bitmask
        var x = 0
        for (num in nums) if (num and diff != 0) x = x xor num
        return intArrayOf(x, bitmask xor x)
    }
}
