package explore.datastructure.treesgraphs.e4

import java.lang.Exception

class Solution {
    fun deepestLeavesSum(root: TreeNode?): Int {
        val queue = ArrayDeque<TreeNode>().apply { add(root!!) }
        while (queue.isNotEmpty()) {
            var sum = 0
            repeat(queue.size) {
                val node = queue.removeFirst()
                sum += node.`val`
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
            if (queue.isEmpty()) return sum
        }
        throw Exception()
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
