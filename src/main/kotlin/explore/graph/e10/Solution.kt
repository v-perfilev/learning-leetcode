package explore.graph.e10

class Solution {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null
        val graphMap = buildGraphMap(node)
        return buildNodeFromGraphMap(graphMap)
    }

    private fun buildGraphMap(root: Node): Map<Int, IntArray> {
        val resMap = mutableMapOf<Int, IntArray>()

        val stack = ArrayDeque<Node>().also { it.add(root) }
        val visitedSet = mutableSetOf<Int>()

        while (stack.isNotEmpty()) {
            val node = stack.removeFirst()

            if (visitedSet.contains(node.`val`)) continue
            visitedSet.add(node.`val`)
            resMap[node.`val`] = node.neighbors.map { it.`val` }.toIntArray()

            node.neighbors.forEach { stack.addFirst(it) }
        }

        return resMap
    }

    private fun buildNodeFromGraphMap(graphMap: Map<Int, IntArray>): Node {
        val nodeMap = mutableMapOf<Int, Node>()
        graphMap.forEach { nodeMap[it.key] = Node(it.key) }
        graphMap.forEach { it.value.forEach { i -> nodeMap[it.key]!!.neighbors.add(nodeMap[i]!!) } }
        return nodeMap[1]!!
    }

    companion object {
        class Node(var `val`: Int) {
            var neighbors: ArrayList<Node> = ArrayList()
        }
    }
}
