package explore.binarytree.e4

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return listOf()
        val resultList = mutableListOf<List<Int>>()
        val queue = ArrayDeque<TreeNode>()
        queue.addFirst(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            val levelList = mutableListOf<Int>()
            for (i in 0..<size) {
                val node = queue.removeFirst()
                levelList.add(node.`val`)
                if (node.left != null) queue.add(node.left!!)
                if (node.right != null) queue.add(node.right!!)
            }
            resultList.add(levelList)
        }
        return resultList
    }

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
