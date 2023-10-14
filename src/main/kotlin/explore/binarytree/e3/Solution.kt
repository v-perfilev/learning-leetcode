package explore.binarytree.e3

class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return listOf()
        val result = mutableListOf<Int>()
        result.addAll(postorderTraversal(root.left))
        result.addAll(postorderTraversal(root.right))
        result.add(root.`val`)
        return result
    }

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
