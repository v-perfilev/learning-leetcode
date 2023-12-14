package problems.t637

class Solution {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        if (root == null) return doubleArrayOf()
        val averageList = mutableListOf<Double>()
        var nodeList = listOf(root)
        while (nodeList.isNotEmpty()) {
            val average = nodeList.map { it.`val` }.average()
            averageList.add(average)
            nodeList = nodeList.flatMap { listOfNotNull(it.left, it.right) }
        }
        return averageList.toDoubleArray()
    }

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
