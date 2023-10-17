package explore.binarytree.e13

class Solution {
    private var ancestor: TreeNode? = null

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        findAncestor(root, p!!, q!!)
        return ancestor
    }

    private fun findAncestor(node: TreeNode?, p: TreeNode, q: TreeNode): Boolean {
        if (node == null) return false
        val isNode = if (node.`val` == p.`val` || node.`val` == q.`val`) 1 else 0
        val isLeft = if (findAncestor(node.left, p, q)) 1 else 0
        val isRight = if (findAncestor(node.right, p, q)) 1 else 0
        val sum = isNode + isLeft + isRight
        if (sum > 1) this.ancestor = node
        return sum > 0
    }

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
