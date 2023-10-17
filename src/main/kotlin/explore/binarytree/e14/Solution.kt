package explore.binarytree.e14

import java.lang.StringBuilder
import kotlin.math.max
import kotlin.math.pow

class Solution {
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        if (root == null) return ""
        val queue = ArrayDeque<TreeNode?>()
        queue.add(root)
        val sb = StringBuilder()
        var position = 0
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if (node == null) {
                sb.append("null")
            } else {
                sb.append(node.`val`)
                position = sb.length
                queue.add(node.left)
                queue.add(node.right)
            }
            sb.append(",")
        }
        return sb.substring(0..<position)
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) return null
        val values = data.split(",").map { it.toIntOrNull() }
        val root = TreeNode(values[0]!!)
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        var i = 1
        while (i < values.size && queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if (i < values.size && values[i] != null) {
                node.left = TreeNode(values[i]!!)
                queue.add(node.left!!)
            }
            i++
            if (i < values.size && values[i] != null) {
                node.right = TreeNode(values[i]!!)
                queue.add(node.right!!)
            }
            i++
        }

        return root
    }

    // Encodes a URL to a shortened URL.
    fun serialize2(root: TreeNode?): String {
        if (root == null) return ""
        val resultArray = createResultArray(root)
        fillResultArray(resultArray, root, 0)
        return resultArray.joinToString(",")
    }

    // Decodes your encoded data to tree.
    fun deserialize2(data: String): TreeNode? {
        if (data.isEmpty()) return null
        val values = data.split(",").map { it.toIntOrNull() }
        return buildNode(values, 0)
    }

    private fun createResultArray(root: TreeNode): Array<Int?> {
        val depth = calcDepth(root, 1)
        val length = 2.0.pow(depth).toInt() - 1
        return arrayOfNulls(length)
    }

    private fun calcDepth(node: TreeNode?, nodeLevel: Int): Int {
        if (node == null) return nodeLevel - 1
        val leftChildDepth = calcDepth(node.left, nodeLevel + 1)
        val rightChildDepth = calcDepth(node.right, nodeLevel + 1)
        return max(leftChildDepth, rightChildDepth)
    }

    private fun fillResultArray(resultArray: Array<Int?>, node: TreeNode?, index: Int) {
        if (node == null) return
        resultArray[index] = node.`val`
        fillResultArray(resultArray, node.left, 2 * index + 1)
        fillResultArray(resultArray, node.right, 2 * index + 2)
    }

    private fun buildNode(values: List<Int?>, index: Int): TreeNode? {
        if (index >= values.size || values[index] == null) return null
        val node = TreeNode(values[index]!!)
        node.left = buildNode(values, 2 * index + 1)
        node.right = buildNode(values, 2 * index + 2)
        return node
    }

    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }
    }
}
