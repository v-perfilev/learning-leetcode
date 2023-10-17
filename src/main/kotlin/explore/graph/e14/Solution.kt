package explore.graph.e14

import java.util.LinkedList

class Solution {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        if (graph.isEmpty()) return listOf()
        return bfs(graph)
    }

    private fun bfs(graph: Array<IntArray>): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val queue = LinkedList<List<Int>>().also { it.add(listOf(0)) }
        while (queue.isNotEmpty()) {
            val path = queue.poll()
            val node = path.last()
            graph[node].forEach { nextNode ->
                val newPath = ArrayList<Int>(path).also { it.add(nextNode) }
                if (nextNode == graph.size - 1) res.add(newPath)
                else queue.offer(newPath)
            }
        }
        return res
    }
}
