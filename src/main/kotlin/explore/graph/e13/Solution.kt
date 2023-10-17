package explore.graph.e13

class Solution {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val edgeMap = buildEdgeMap(n, edges)
        // return dfs(edgeMap, source, destination)
        return bfs(edgeMap, source, destination)
    }

    private fun buildEdgeMap(n: Int, edges: Array<IntArray>): Map<Int, Set<Int>> {
        val map = mutableMapOf<Int, MutableSet<Int>>()
        for (i in 0..<n) {
            map[i] = HashSet()
        }
        edges.forEach { (source, destination) ->
            map[source]!!.add(destination)
            map[destination]!!.add(source)
        }
        return map
    }

    private fun dfs(edgeMap: Map<Int, Set<Int>>, source: Int, destination: Int): Boolean {
        val visited = BooleanArray(edgeMap.size)
        val stack = ArrayDeque<Int>().also { it.addFirst(source) }
        while (stack.isNotEmpty()) {
            val node = stack.removeFirst()
            if (node == destination) return true
            if (visited[node]) continue
            visited[node] = true
            edgeMap[node]!!.forEach { stack.addFirst(it) }
        }
        return false
    }

    private fun bfs(edgeMap: Map<Int, Set<Int>>, source: Int, destination: Int): Boolean {
        val visited = BooleanArray(edgeMap.size)
        val queue = ArrayDeque<Int>().also { it.addFirst(source) }
        while (queue.isNotEmpty()) {
            val node = queue.removeLast()
            if (node == destination) return true
            if (visited[node]) continue
            visited[node] = true
            edgeMap[node]!!.forEach { queue.addFirst(it) }
        }
        return false
    }
}
