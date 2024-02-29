package problems.t1973

class Solution {
    fun equalToDescendants(root: TreeNode?): Int {
        return countNodes(root!!).second
    }

    private fun countNodes(node: TreeNode): Pair<Int, Int> {
        val left = node.left?.let { countNodes(node.left!!) } ?: (0 to 0)
        val right = node.right?.let { countNodes(node.right!!) } ?: (0 to 0)
        val sum = node.`val` + left.first + right.first
        var count = left.second + right.second
        if (node.`val` == left.first + right.first) count++
        return sum to count
    }

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
