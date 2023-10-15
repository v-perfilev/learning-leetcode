package explore.binarytree.e6

class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        return isMirror(root, root)
    }

    private fun isMirror(leftNode: TreeNode?, rightNode: TreeNode?): Boolean {
        if (leftNode == null && rightNode == null) return true
        if (leftNode == null || rightNode == null) return false
        if (leftNode.`val` != rightNode.`val`) return false
        return isMirror(leftNode.left, rightNode.right) && isMirror(leftNode.right, rightNode.left)
    }

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
