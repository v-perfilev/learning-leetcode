package explore.bit.e7

class Solution {
    fun rangeBitwiseAnd(left: Int, right: Int): Int {
        var shift = 0
        var l = left
        var r = right
        while (l < r) {
            l = l shr 1
            r = r shr 1
            shift++
        }
        return l shl shift
    }
}
