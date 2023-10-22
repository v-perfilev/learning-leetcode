package explore.binarysearch.e13

class Solution {
    fun isPerfectSquare(num: Int): Boolean {
        val square = sqrt(num)
        return square * square == num
    }

    private fun sqrt(x: Int): Int {
        if (x < 2) return x
        var a = 0
        var b = x / 2
        var mid: Int
        do {
            mid = a + (b - a) / 2
            if (powTwo(mid) == x.toLong()) return mid
            if (powTwo(mid) > x) b = mid - 1
            if (powTwo(mid) < x) a = mid + 1
        } while (powTwo(mid) > x || powTwo(mid + 1) <= x)
        return mid
    }

    private fun powTwo(value: Int): Long = value.toLong() * value.toLong()
}
