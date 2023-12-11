package problems.t501

class Solution {
    private lateinit var modeList: MutableSet<Int>
    private var totalMax = 0
    private var currentVal = 0

    fun findMode(root: TreeNode?): IntArray {
        this.modeList = mutableSetOf()
        handleNode(root)
        return modeList.toIntArray()
    }

    private fun handleNode(node: TreeNode?) {
        if (node == null) return
        this.currentVal = node.`val`
        val currentMax = count(node)
        if (currentMax > this.totalMax) {
            this.totalMax = currentMax
            modeList.clear()
            modeList.add(currentVal)
        } else if (currentMax == this.totalMax) {
            modeList.add(currentVal)
        }
        handleNode(node.left)
        handleNode(node.right)
    }

    private fun count(node: TreeNode?): Int {
        if (node == null) return 0
        var count = count(node.left) + count(node.right)
        if (node.`val` == this.currentVal) count++
        return count
    }

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
