package problems.t1457

class Solution {
    private lateinit var counts: IntArray
    private var res = 0

    fun pseudoPalindromicPaths(root: TreeNode?): Int {
        if (root == null) return 0
        counts = IntArray(10)
        dfs(root)
        return res
    }

    private fun dfs(node: TreeNode) {
        val value = node.`val`
        counts[value]++
        if (node.left != null) dfs(node.left!!)
        if (node.right != null) dfs(node.right!!)
        if (node.left == null && node.right == null) checkPseudoPalindromic()
        counts[value]--
    }

    private fun checkPseudoPalindromic() {
        if (counts.filter { it % 2 == 1 }.size <= 1) res++
    }

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
