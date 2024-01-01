package explore.bit.e12

class Solution {
    private lateinit var seats: Array<CharArray>
    private lateinit var memo: Array<Array<Array<IntArray>>>
    private var m = 0
    private var n = 0

    fun maxStudents(seats: Array<CharArray>): Int {
        this.m = seats.size
        this.n = seats.first().size
        this.seats = seats
        this.memo = Array(m) { Array(n) { Array(1 shl m) { IntArray(1 shl m) { -1 } } } }
        return dp(0, 0, 0, 0)
    }

    private fun dp(row: Int, col: Int, prevMask: Int, mask: Int): Int {
        if (col >= this.n) return 0
        if (row >= this.m) return dp(0, col + 1, mask, 0)
        if (memo[row][col][prevMask][mask] != -1) return memo[row][col][prevMask][mask]

        val option1 = dp(row + 1, col, prevMask, mask)

        var option2 = Int.MIN_VALUE
        if (isSeatFree(row, col, prevMask)) {
            option2 = 1 + dp(row + 1, col, prevMask, mask or (1 shl row))
        }

        memo[row][col][prevMask][mask] = maxOf(option1, option2)
        return memo[row][col][prevMask][mask]
    }

    private fun isSeatFree(row: Int, col: Int, prevMask: Int): Boolean {
        val isSeatFree = seats[row][col] != '#'
        val noNeighbors = intArrayOf(row - 1, row, row + 1)
            .filter { it in 0..<m }
            .all { (prevMask shr it) and 1 == 0 }
        return isSeatFree && noNeighbors
    }
}
