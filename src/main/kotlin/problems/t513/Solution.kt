package problems.t513

class Solution {
    fun findBottomLeftValue(root: TreeNode?): Int {
        var bottomLeftValue = 0
        val queue = ArrayDeque<TreeNode>().apply { addLast(root!!) }
        while (queue.isNotEmpty()) {
            bottomLeftValue = queue.first().`val`
            val queueSize = queue.size
            repeat(queueSize) {
                val node = queue.removeFirst()
                node.left?.let { queue.addLast(it) }
                node.right?.let { queue.addLast(it) }
            }
        }
        return bottomLeftValue
    }

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
