package explore.binarytree.e1

class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return listOf()
        val lis = mutableListOf<Int>()
        preorderTraversal(root, lis)
        return lis
    }

    private fun preorderTraversal(node: TreeNode?, list: MutableList<Int>) {
        if (node == null) return
        list.add(node.`val`)
        preorderTraversal(node.left, list)
        preorderTraversal(node.right, list)
    }

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
