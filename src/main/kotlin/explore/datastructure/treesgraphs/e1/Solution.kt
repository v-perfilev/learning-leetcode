package explore.datastructure.treesgraphs.e1

class Solution {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return minDepth(root, 1)
    }

    private fun minDepth(node: TreeNode, depth: Int): Int {
        if (node.left == null && node.right == null) return depth
        val left = if (node.left == null) Int.MAX_VALUE else minDepth(node.left!!, depth + 1)
        val right = if (node.right == null) Int.MAX_VALUE else minDepth(node.right!!, depth + 1)
        return minOf(left, right)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
