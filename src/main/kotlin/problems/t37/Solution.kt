package problems.t37

class Solution {
    companion object {
        private const val TOTAL_SIZE = 9
        private const val AREA_SIZE = 3
        private val ALL_CANDIDATES = ('1'..'9').toList()
    }

    private lateinit var board: Array<CharArray>

    fun solveSudoku(board: Array<CharArray>) {
        this.board = board
        backtracking(0, 0)
    }

    private fun backtracking(row: Int, col: Int): Boolean {
        if (row == TOTAL_SIZE) {
            return true
        }
        if (col == TOTAL_SIZE) {
            return backtracking(row + 1, 0)
        }
        if (this.board[row][col] != '.') {
            return backtracking(row, col + 1)
        }
        val candidates = getCandidates(row, col)
        for (candidate in candidates) {
            this.board[row][col] = candidate
            if (backtracking(row, col + 1)) {
                return true
            }
            this.board[row][col] = '.'
        }
        return false
    }

    private fun getCandidates(row: Int, col: Int): List<Char> {
        val rowCandidates = getRowCandidates(row)
        val colCandidates = getColCandidates(col)
        val areaCandidates = getAreaCandidates(row, col)
        return rowCandidates.intersect(colCandidates).intersect(areaCandidates).toList()
    }

    private fun getRowCandidates(row: Int): Set<Char> {
        val presentedValues = this.board[row].filter { it != '.' }.toSet()
        return ALL_CANDIDATES.filter { !presentedValues.contains(it) }.toSet()
    }

    private fun getColCandidates(col: Int): Set<Char> {
        val presentedValues = this.board.map { it[col] }.filter { it != '.' }.toSet()
        return ALL_CANDIDATES.filter { !presentedValues.contains(it) }.toSet()
    }

    private fun getAreaCandidates(row: Int, col: Int): Set<Char> {
        val firstRow = row - row % AREA_SIZE
        val firstCol = col - col % AREA_SIZE
        val presentedValues = this.board
            .slice(firstRow..<firstRow + AREA_SIZE)
            .flatMap { it.slice(firstCol..<firstCol + AREA_SIZE) }
            .filter { it != '.' }
            .toSet()
        return ALL_CANDIDATES.filter { !presentedValues.contains(it) }.toSet()
    }
}
