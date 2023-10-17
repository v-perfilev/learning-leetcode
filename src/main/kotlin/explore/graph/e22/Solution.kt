package explore.graph.e22

import kotlin.math.abs

class Solution {
    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val rows = heights.size
        val cols = heights[0].size
        val pq = ArrayDeque<IntArray>().apply { add(intArrayOf(0, 0)) }
        val efforts = Array(rows) { IntArray(cols) { Int.MAX_VALUE } }
        efforts[0][0] = 0
        while (pq.isNotEmpty()) {
            val (x, y) = pq.removeFirst()
            directions
                .filter { (dx, dy) -> x + dx in 0..<rows && y + dy in 0..<cols }
                .map { (dx, dy) -> intArrayOf(x + dx, y + dy, abs(heights[x + dx][y + dy] - heights[x][y])) }
                .filter { (newX, newY, effort) -> maxOf(efforts[x][y], effort) < efforts[newX][newY] }
                .forEach { (newX, newY, effort) ->
                    efforts[newX][newY] = maxOf(efforts[x][y], effort)
                    pq.add(intArrayOf(newX, newY))
                }
        }
        return efforts[rows - 1][cols - 1]
    }

    companion object {
        private val directions = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(0, 1),
        )
    }
}
