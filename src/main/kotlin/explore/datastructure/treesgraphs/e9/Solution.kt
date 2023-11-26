package explore.datastructure.treesgraphs.e9

class Solution {
    private lateinit var grid: Array<IntArray>
    private lateinit var visited: Array<BooleanArray>
    private var vSize: Int = 0
    private var hSize: Int = 0

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        this.grid = grid
        this.vSize = grid.size
        this.hSize = grid.first().size
        this.visited = Array(vSize) { BooleanArray(hSize) }

        var max = 0
        for (y in 0..<vSize) {
            for (x in 0..<hSize) {
                if (visited[y][x]) continue
                if (grid[y][x] == 0) visited[y][x] = true
                else max = maxOf(max, dfs(y, x))
            }
        }
        return max
    }

    private fun dfs(y: Int, x: Int): Int {
        if (visited[y][x]) return 0
        visited[y][x] = true
        return 1 + directions.map { (dy, dx) -> dy + y to dx + x }
            .filter { (newY, newX) -> newY in 0..<vSize && newX in 0..<hSize }
            .filter { (newY, newX) -> grid[newY][newX] == 1 }
            .sumOf { (newY, newX) -> dfs(newY, newX) }
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
