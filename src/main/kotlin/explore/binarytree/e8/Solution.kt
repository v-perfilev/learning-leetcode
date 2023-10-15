package explore.binarytree.e8

class Solution {
    fun countUnivalSubtrees(node: TreeNode?): Int {
        return getUnivalSubtrees(node).first
    }

    private fun getUnivalSubtrees(node: TreeNode?): Pair<Int, Boolean> {
        if (node == null) return Pair(0, true)
        if (node.left == null && node.right == null) return Pair(1, true)
        val leftPair = getUnivalSubtrees(node.left)
        val rightPair = getUnivalSubtrees(node.right)
        val isUnivalSubtree = leftPair.second && rightPair.second && checkChildren(node)
        val counter = leftPair.first + rightPair.first + if (isUnivalSubtree) 1 else 0
        return Pair(counter, isUnivalSubtree)
    }

    private fun checkChildren(node: TreeNode): Boolean =
        (node.left == null || node.`val` == node.left!!.`val`)
            && (node.right == null || node.`val` == node.right!!.`val`)

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
