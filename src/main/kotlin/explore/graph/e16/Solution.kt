package explore.graph.e16

import java.util.LinkedList

class Solution {
    fun levelOrder(root: Node?): List<List<Int>> {
        if (root == null) return emptyList()
        val res = mutableListOf<List<Int>>()
        val queue = LinkedList<Node>().apply { offer(root) }
        while (queue.isNotEmpty()) {
            val queueSize = queue.size
            val levelNodeList = ArrayList<Int>(queueSize)
            repeat(queueSize) {
                val node = queue.poll()
                levelNodeList.add(node.`val`)
                node.children.forEach { queue.offer(it) }
            }
            res.add(levelNodeList)
        }
        return res
    }

    companion object {
        class Node(var `val`: Int) {
            var children: List<Node?> = listOf()
        }
    }
}
