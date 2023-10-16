package explore.binarytree.e9

// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]

class Solution {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        val root = TreeNode(postorder.last())
        for (j in postorder.size - 2 downTo 0) {
            val value = postorder[j]
            var node = root
            var isLeft = isLeftChild(inorder, node.`val`, value)
            while ((isLeft && node.left != null) || (!isLeft && node.right != null)) {
                node = if (isLeft) node.left!! else node.right!!
                isLeft = isLeftChild(inorder, node.`val`, value)
            }
            if (isLeft) {
                node.left = TreeNode(value)
            } else {
                node.right = TreeNode(value)
            }
        }
        return root
    }

    private fun isLeftChild(inorder: IntArray, parentValue: Int, childValue: Int): Boolean {
        inorder.forEach {
            if (it == childValue) return true
            if (it == parentValue) return false
        }
        throw Exception()
    }

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
