package explore.datastructure.treesgraphs.e3

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        return dfs(root!!).first
    }

    private fun dfs(node: TreeNode?): Pair<Int, Int> { // diameter, depth
        if (node == null) return 0 to 0
        val (leftDiameter, leftDepth) = dfs(node.left)
        val (rightDiameter, rightDepth) = dfs(node.right)

        val diameter = leftDepth + rightDepth
        val maxDiameter = maxOf(leftDiameter, rightDiameter, diameter)
        val maxDepth = maxOf(leftDepth, rightDepth) + 1

        return maxDiameter to maxDepth
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
