package problems.t1245

class Solution {
    fun treeDiameter(edges: Array<IntArray>): Int {
        val n = edges.size + 1
        val graph = MutableList<MutableList<Int>>(n) { mutableListOf() }
        edges.forEach { edge ->
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }
        fun bfs(start: Int): Pair<Int, Int> {
            val queue: MutableList<Int> = mutableListOf(start)
            val distances = IntArray(n) { -1 }
            distances[start] = 0
            var current = start
            while (queue.isNotEmpty()) {
                current = queue.removeAt(0)
                for (neighbor in graph[current]) {
                    if (distances[neighbor] == -1) {
                        queue.add(neighbor)
                        distances[neighbor] = distances[current] + 1
                    }
                }
            }
            return Pair(current, distances[current])
        }
        val (farthestNode, _) = bfs(0)
        val (_, diameter) = bfs(farthestNode)
        return diameter
    }
}
