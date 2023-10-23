package problems.t2265

class Solution {
    fun averageOfSubtree(root: TreeNode?): Int {
        if (root == null) return 0
        val nodeProduct = sumAndCountSubtree(root)
        return nodeProduct.res
    }

    private fun sumAndCountSubtree(node: TreeNode?): NodeProduct {
        if (node == null) return NodeProduct(0, 0, 0)
        val left = sumAndCountSubtree(node.left)
        val right = sumAndCountSubtree(node.right)
        val sum = node.`val` + left.sum + right.sum
        val count = 1 + left.count + right.count
        var res = left.res + right.res
        if (node.`val` == sum / count) res++
        return NodeProduct(sum, count, res)
    }

    companion object {
        class NodeProduct(val sum: Int, val count: Int, val res: Int)

        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
