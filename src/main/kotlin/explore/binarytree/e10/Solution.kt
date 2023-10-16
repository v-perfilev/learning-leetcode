package explore.binarytree.e10

// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]

class Solution {
    private var preorder = intArrayOf()
    private var inorderMap = mutableMapOf<Int, Int>()
    private var index = 0

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        this.preorder = preorder
        inorder.forEachIndexed { index, it -> inorderMap[it] = index }
        return buildTree(0, inorder.size - 1)
    }

    private fun buildTree(a: Int, b: Int): TreeNode? {
        if (a > b) return null
        val value = preorder[index++]
        val node = TreeNode(value)
        val position = inorderMap[value]!!
        node.left = buildTree(a, position - 1)
        node.right = buildTree(position + 1, b)
        return node
    }

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
