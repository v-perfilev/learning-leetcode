package explore.bit.e4

class Solution {
    fun reverseBits(n: Int): Int {
        var result = 0
        for (i in 0..15) {
            result = (((n shr 31 - i) and 1) shl i) or result
            result = (((n shr i) and 1) shl 31 - i) or result
        }
        return result
    }
}
