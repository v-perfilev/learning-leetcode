package problems.t530

import kotlin.math.abs

class Solution {
    fun getMinimumDifference(root: TreeNode?): Int {
        if (root == null) return Int.MAX_VALUE
        val leftDifference = findLeftDifference(root)
        val rightDifference = findRightDifference(root)
        val leftMinimum = getMinimumDifference(root.left)
        val rightMinimum = getMinimumDifference(root.right)
        return listOf(leftDifference, rightDifference, leftMinimum, rightMinimum).min()
    }

    private fun findLeftDifference(node: TreeNode): Int {
        if (node.left == null) return Int.MAX_VALUE
        var child = node.left!!
        while (child.right != null) {
            child = child.right!!
        }
        return abs(node.`val` - child.`val`)
    }

    private fun findRightDifference(node: TreeNode): Int {
        if (node.right == null) return Int.MAX_VALUE
        var child = node.right!!
        while (child.left != null) {
            child = child.left!!
        }
        return abs(node.`val` - child.`val`)
    }

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
