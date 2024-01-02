package problems.t1424

class Solution {
    fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
        val list = ArrayList<Cell>()
        nums.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, value ->
                list.add(Cell(value, colIndex, colIndex + rowIndex))
            }
        }
        return list.sortedBy { it.col }.sortedBy { it.coordSum }.map { it.value }.toIntArray()
    }

    companion object {
        class Cell(val value: Int, val col: Int, val coordSum: Int)
    }
}
