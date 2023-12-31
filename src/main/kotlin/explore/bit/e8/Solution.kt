package explore.bit.e8

class Solution {
    fun countBits(n: Int): IntArray {
        val res = IntArray(n + 1)
        var shift = 1
        var nextShift = 2
        for (i in 1..n) {
            res[i] = 1 + res[i - shift]
            if (i+1 == nextShift) {
                shift = nextShift
                nextShift = nextShift shl 1
            }
        }
        return res
    }
}
