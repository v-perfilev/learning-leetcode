package explore.datastructure.treesgraphs.e15

class Solution {
    fun maximumDetonation(bombs: Array<IntArray>): Int {
        val graph = buildGraph(bombs)
        var max = 0
        for (i in bombs.indices) {
            val visited = BooleanArray(bombs.size)
            dfs(graph, visited, i)
            val explodedBombsCount = visited.count { it }
            if (explodedBombsCount == bombs.size) return explodedBombsCount
            max = maxOf(max, explodedBombsCount)
        }
        return max
    }

    private fun dfs(graph: Array<IntArray>, visited: BooleanArray, i: Int) {
        if (visited[i]) return
        visited[i] = true
        graph[i].forEach { dfs(graph, visited, it) }
    }

    private fun buildGraph(bombs: Array<IntArray>): Array<IntArray> {
        return bombs.mapIndexed { i1, bomb1 ->
            bombs.mapIndexedNotNull { i2, bomb2 ->
                if (i1 != i2 && canExplode(bomb1, bomb2)) i2 else null
            }.toIntArray()
        }.toTypedArray()
    }

    private fun canExplode(bomb1: IntArray, bomb2: IntArray): Boolean {
        val dx = bomb1[0] - bomb2[0]
        val dy = bomb1[1] - bomb2[1]
        val distanceSquared = dx * dx.toLong() + dy * dy.toLong()
        return distanceSquared <= bomb1[2] * bomb1[2].toLong()
    }
}
