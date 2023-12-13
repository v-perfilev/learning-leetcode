package problems.t606

class Solution {
    fun tree2str(root: TreeNode?): String {
        if (root == null) return ""
        val sb = StringBuilder()
        sb.append(root.`val`)
        if (root.left != null || root.right != null) sb.append("(${tree2str(root.left)})")
        if (root.right != null) sb.append("(${tree2str(root.right)})")
        return sb.toString()
    }

    companion object {
        class TreeNode(val `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
