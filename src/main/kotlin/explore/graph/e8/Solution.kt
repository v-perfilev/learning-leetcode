package explore.graph.e8

class Solution {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val adjacentEdgeMap = HashMap<Int, HashSet<Int>>()
            .also { for (i in 0..n) it[i] = HashSet() }
        edges.forEach {
            adjacentEdgeMap[it[0]]!!.add(it[1])
            adjacentEdgeMap[it[1]]!!.add(it[0])
        }
        val visited = BooleanArray(n)
        val stack = ArrayDeque<Int>().also { it.addFirst(source) }
        while (stack.isNotEmpty()) {
            val node = stack.removeFirst()

            if (node == destination) return true
            if (visited[node]) continue
            visited[node] = true

            adjacentEdgeMap[node]!!.forEach { stack.addFirst(it) }
        }
        return false
    }
}
