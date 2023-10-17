package explore.graph.e15

import java.util.LinkedList

class Solution {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        val n = grid.size
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1

        val queue = LinkedList<IntArray>().apply { offer(intArrayOf(0, 0)) }
        val visited = Array(n) { BooleanArray(n) }.also { it[0][0] = true }

        var pathCount = 1
        var stepCounter = 1
        var queueLength = 1

        while (queue.isNotEmpty()) {
            if (stepCounter == queueLength) {
                stepCounter = 0
                queueLength = queue.size
                pathCount++
            }
            val (y, x) = queue.poll()
            visited[y][x] = true
            if (y == n - 1 && x == n - 1) return pathCount

            for ((dy, dx) in directions) {
                val newY = y + dy
                val newX = x + dx
                if (newY in 0..<n && newX in 0..<n && !visited[newY][newX] && grid[newY][newX] == 0) {
                    queue.offer(intArrayOf(newY, newX))
                }
            }
            stepCounter++
        }
        return -1
    }

    companion object {
        val directions = arrayOf(
            intArrayOf(-1, -1), intArrayOf(-1, 0), intArrayOf(-1, 1),
            intArrayOf(0, -1), intArrayOf(0, 1),
            intArrayOf(1, -1), intArrayOf(1, 0), intArrayOf(1, 1)
        )
    }
}
