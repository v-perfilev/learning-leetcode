package explore.graph.e17

import java.util.LinkedList

class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        var freshCount = 0
        val rottenGrid = Array(m) { BooleanArray(n) }
        val queue = LinkedList<IntArray>()
        grid.forEachIndexed { y, row ->
            row.forEachIndexed { x, value ->
                if (value == 2) {
                    rottenGrid[y][x] = true
                    queue.offer(intArrayOf(y, x))
                } else if (value == 1) {
                    freshCount++
                }
            }
        }

        if (freshCount == 0) return 0

        var minutes = -1
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val (y, x) = queue.poll()
                for ((dy, dx) in directions) {
                    val newY = y + dy
                    val newX = x + dx
                    if (newY in 0..<m && newX in 0..<n && grid[newY][newX] == 1 && !rottenGrid[newY][newX]) {
                        freshCount--
                        rottenGrid[newY][newX] = true
                        queue.offer(intArrayOf(newY, newX))
                    }
                }
            }
            minutes++
        }
        return if (freshCount == 0) minutes else -1
    }

    companion object {
        val directions = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(0, 1),
        )
    }
}
