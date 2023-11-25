package explore.datastructure.treesgraphs.e5

import java.util.LinkedList

class Solution {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val resList = mutableListOf<List<Int>>()
        val deque = ArrayDeque<TreeNode>().apply { add(root) }
        var reversed = false
        while (deque.isNotEmpty()) {
            val layerList = LinkedList<Int>()
            repeat(deque.size) {
                val node = deque.removeFirst()
                if (reversed) layerList.addFirst(node.`val`)
                else layerList.add(node.`val`)
                node.left?.let { deque.add(it) }
                node.right?.let { deque.add(it) }
            }
            resList.add(layerList)
            reversed = !reversed
        }
        return resList
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
