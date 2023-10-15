package explore.binarytree.e7

class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        return hasPathSum(root, targetSum, 0)
    }

    private fun hasPathSum(node: TreeNode?, targetSum: Int, parentSum: Int): Boolean {
        if (node == null) return false
        if (node.left == null && node.right == null && node.`val` + parentSum == targetSum) return true
        return hasPathSum(node.left, targetSum, node.`val` + parentSum)
            || hasPathSum(node.right, targetSum, node.`val` + parentSum)
    }

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
