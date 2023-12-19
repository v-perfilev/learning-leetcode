package problems.t1120

class Solution {
    private var max = Double.MIN_VALUE

    fun maximumAverageSubtree(root: TreeNode?): Double {
        calcNode(root!!)
        return max
    }

    private fun calcNode(node: TreeNode): Pair<Double, Int> {
        if (node.left == null && node.right == null) {
            max = maxOf(max, node.`val`.toDouble())
            return node.`val`.toDouble() to 1
        }
        var sum = node.`val`.toDouble()
        var count = 1
        if (node.left != null) {
            val left = calcNode(node.left!!)
            sum += left.first * left.second
            count += left.second
        }
        if (node.right != null) {
            val right = calcNode(node.right!!)
            sum += right.first * right.second
            count += right.second
        }
        val average = sum / count
        max = maxOf(max, average)
        return average to count
    }

    companion object {
        class TreeNode(val `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
