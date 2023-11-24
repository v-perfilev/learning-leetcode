package explore.datastructure.treesgraphs.e2

class Solution {
    fun maxAncestorDiff(root: TreeNode?): Int {
        if (root == null) return -1
        return maxAncestorDiff(root, root.`val`, root.`val`)
    }

    private fun maxAncestorDiff(node: TreeNode?, min: Int, max: Int): Int {
        if (node == null) return max - min

        val newMin = minOf(min, node.`val`)
        val newMax = maxOf(max, node.`val`)

        val left = maxAncestorDiff(node.left, newMin, newMax)
        val right = maxAncestorDiff(node.right, newMin, newMax)
        return maxOf(left, right)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
