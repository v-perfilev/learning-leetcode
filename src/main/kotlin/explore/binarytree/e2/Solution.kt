package explore.binarytree.e2

class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return listOf()
        val result = mutableListOf<Int>()
        result.addAll(inorderTraversal(root.left))
        result.add(root.`val`)
        result.addAll(inorderTraversal(root.right))
        return result
    }

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
