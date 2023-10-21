package explore.binarysearch.e10

import kotlin.math.abs
import kotlin.math.min

class Solution {
    fun closestValue(node: TreeNode?, target: Double): Int {
        if (node == null) return Int.MAX_VALUE
        val closestChildVal = closestValue(if (node.`val` > target) node.left else node.right, target)
        val nodeDiff = abs(node.`val` - target)
        val childDiff = abs(closestChildVal - target)
        if (nodeDiff == childDiff) return min(node.`val`, closestChildVal)
        return if (nodeDiff < childDiff) node.`val` else closestChildVal
    }

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
