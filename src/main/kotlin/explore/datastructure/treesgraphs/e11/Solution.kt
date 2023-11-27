package explore.datastructure.treesgraphs.e11

class Solution {
    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val ySize = maze.size
        val xSize = maze.first().size
        val queue = ArrayDeque<IntArray>().apply { add(entrance) }
        val visited = Array(ySize) { BooleanArray(xSize) }
        val (entranceY, entranceX) = entrance
        var step = 0
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val (y, x) = queue.removeFirst()
                if ((y != entranceY || x != entranceX)
                    && (y == 0 || y == ySize - 1 || x == 0 || x == xSize - 1)
                ) return step
                if (!visited[y][x]) {
                    visited[y][x] = true
                    directions.map { (dy, dx) -> dy + y to dx + x }
                        .filter { (newY, newX) -> newY in 0..<ySize && newX in 0..<xSize }
                        .filter { (newY, newX) -> maze[newY][newX] == '.' }
                        .forEach { queue.add(intArrayOf(it.first, it.second)) }
                }
            }
            step++
        }
        return -1
    }

    companion object {
        private var directions = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(0, 1),
        )
    }
}
