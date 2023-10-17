package explore.graph.e25

class Solution {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        val graph = createGraph(n, edges)
        val queue = initQueue(graph)
        var count = n
        while (count > 2) {
            count -= queue.size
            repeat(queue.size) {
                val node = queue.removeFirst()
                graph[node].forEach { neighbor ->
                    graph[neighbor].remove(node)
                    if (graph[neighbor].size == 1)
                        queue.add(neighbor)
                }
            }
        }
        return queue
    }

    private fun createGraph(n: Int, edges: Array<IntArray>): Array<MutableSet<Int>> =
        Array(n) { mutableSetOf<Int>() }.also {
            edges.forEach { (a, b) ->
                it[a].add(b)
                it[b].add(a)
            }
        }

    private fun initQueue(graph: Array<MutableSet<Int>>): ArrayDeque<Int> =
        ArrayDeque<Int>().apply {
            graph.forEachIndexed { index, node ->
                if (node.size == 1) add(index)
            }
        }
}
