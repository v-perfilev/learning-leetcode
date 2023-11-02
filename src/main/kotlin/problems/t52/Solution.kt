package problems.t52

class Solution {
    private lateinit var board: Array<BooleanArray>
    private var result = 0

    fun totalNQueens(n: Int): Int {
        this.board = Array(n) { BooleanArray(n) }
        this.result = 0
        backtrack(0)
        return this.result
    }

    private fun backtrack(row: Int) {
        if (row == board.size) {
            result++
            return
        }
        for (col in board[row].indices) {
            if (!isValid(row, col)) continue
            board[row][col] = true
            backtrack(row + 1)
            board[row][col] = false
        }
    }

    private fun isValid(row: Int, col: Int): Boolean {
        for (i in 0..<row) {
            if (board[i][col]) return false
        }
        var i = row - 1
        var j = col - 1
        while (i >= 0 && j >= 0) {
            if (board[i][j]) return false
            i--
            j--
        }
        i = row - 1
        j = col + 1
        while (i >= 0 && j < board.size) {
            if (board[i][j]) return false
            i--
            j++
        }
        return true
    }
}
