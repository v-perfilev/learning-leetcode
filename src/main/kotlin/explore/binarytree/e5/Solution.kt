package explore.binarytree.e5

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        var nodeList = listOf(root)
        var depth = 0
        while (nodeList.isNotEmpty()) {
            nodeList = nodeList.flatMap { listOfNotNull(it.left, it.right) }
            depth++
        }

        return depth
    }

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
