package problems.t1609

class Solution {
    class Solution {
        fun isEvenOddTree(root: TreeNode?): Boolean {
            val queue = ArrayDeque<TreeNode>().apply { addLast(root!!) }
            var level = 0
            while (queue.isNotEmpty()) {
                val size = queue.size
                var prev: Int? = null
                repeat(size) {
                    val node = queue.removeFirst()
                    if (level % 2 == 0) {
                        if (node.`val` % 2 == 0) return false
                        if (node.`val` <= (prev ?: Int.MIN_VALUE)) return false
                    } else {
                        if (node.`val` % 2 == 1) return false
                        if (node.`val` >= (prev ?: Int.MAX_VALUE)) return false
                    }
                    prev = node.`val`
                    node.left?.let { queue.addLast(node.left!!) }
                    node.right?.let { queue.addLast(node.right!!) }
                }
                level++
            }
            return true
        }
    }

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
