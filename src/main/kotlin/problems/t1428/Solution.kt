package problems.t1428

class Solution {
    fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
        if (!checkRowPresence(binaryMatrix)) return -1
        return findColumn(binaryMatrix)
    }

    private fun findColumn(binaryMatrix: BinaryMatrix): Int {
        val (rows, cols) = binaryMatrix.dimensions()
        var right = cols - 1
        for (i in 0..<rows) {
            right = minOf(right, binarySearch(binaryMatrix, i, right))
        }
        return right
    }

    private fun binarySearch(binaryMatrix: BinaryMatrix, i: Int, right: Int): Int {
        var l = 0
        var r = right
        while (l < r) {
            val mid = l + (r - l) / 2
            val midValue = binaryMatrix.get(i, mid)
            if (midValue == 1) r = mid
            else l = mid + 1
        }
        return l
    }

    private fun checkRowPresence(binaryMatrix: BinaryMatrix): Boolean {
        val (rows, cols) = binaryMatrix.dimensions()
        for (i in 0..<rows) {
            if (binaryMatrix.get(i, cols - 1) == 1) return true
        }
        return false
    }
}

interface BinaryMatrix {
    fun get(row: Int, col: Int): Int
    fun dimensions(): List<Int>
}
