package explore.binarysearch.e2

class Solution {
    fun mySqrt(x: Int): Int {
        var a = 0
        var b = x
        var mid: Int
        do {
            mid = a + (b - a) / 2
            if (powTwo(mid) == x.toLong()) return mid
            if (powTwo(mid) > x) b = mid - 1
            if (powTwo(mid) < x) a = mid + 1
        } while (powTwo(mid) > x || powTwo(mid + 1) <= x)
        return mid
    }

    private fun powTwo(value: Int): Long = value.toLong() * value
}
