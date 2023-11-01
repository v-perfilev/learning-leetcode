package problems.t36

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        return !(!checkRows(board) || !checkCols(board) || !checkSquares(board))
    }

    private fun checkRows(board: Array<CharArray>): Boolean {
        for (x in 0..8) {
            val set = mutableSetOf<Char>()
            for (y in 0..8) {
                val cell = board[x][y]
                if (cell != '.' && set.contains(cell)) return false
                else set.add(cell)
            }
        }
        return true
    }

    private fun checkCols(board: Array<CharArray>): Boolean {
        for (y in 0..8) {
            val set = mutableSetOf<Char>()
            for (x in 0..8) {
                val cell = board[x][y]
                if (cell != '.' && set.contains(cell)) return false
                else set.add(cell)
            }
        }
        return true
    }

    private fun checkSquares(board: Array<CharArray>): Boolean {
        for (i in 0..2) {
            for (j in 0..2) {
                val set = mutableSetOf<Char>()
                for (x in 0..2) {
                    for (y in 0..2) {
                        val cell = board[i * 3 + x][y * 3 + y]
                        if (cell != '.' && set.contains(cell)) return false
                        else set.add(cell)
                    }
                }
            }
        }
        return true
    }
}
