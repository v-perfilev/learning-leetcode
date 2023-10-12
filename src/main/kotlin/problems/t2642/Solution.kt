package problems.t2642

class Graph(n: Int, edges: Array<IntArray>) {
    private val content: MutableMap<Int, MutableMap<Int, Int>> = mutableMapOf()

    init {
        edges.forEach { addEdge(it) }
    }

    fun addEdge(edge: IntArray) {
        val edgeMap = content.getOrPut(edge[0]) { mutableMapOf() }
        edgeMap[edge[1]] = edge[2]
    }

    fun shortestPath(node1: Int, node2: Int): Int {
        val distancesToNode = mutableMapOf(node1 to 0, node2 to Int.MAX_VALUE)
        val queue = ArrayDeque<Int>().also { it.add(node1) }

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            val childNodes = content.getOrDefault(node, emptyMap())
            childNodes.forEach { cd ->
                val newDistance = distancesToNode[node]!! + cd.value
                val oldDistance = distancesToNode.getOrDefault(cd.key, Int.MAX_VALUE)
                if (newDistance < oldDistance) {
                    distancesToNode[cd.key] = newDistance
                    queue.add(cd.key)
                }
            }
        }

        val resDistance = distancesToNode[node2]!!
        return if (resDistance == Int.MAX_VALUE) -1 else resDistance
    }
}
