package problems.t190

class Solution {
    // you need treat n as an unsigned value
    fun reverseBits(n: Int): Int {
        var result = 0
        for (i in 0..15) {
            val leftBit = (n shr i) and 1
            val rightBit = (n shr 31 - i) and 1
            result = (rightBit shl i) or result
            result = (leftBit shl 31 - i) or result
        }
        return result
    }
}
