package explore.binarytree.e12

class Solution {
    fun connect(root: Node?): Node? {
        recursiveConnect(root)
        recursiveConnect(root)
        return root
    }

    private fun recursiveConnect(node: Node?) {
        if (node == null) return
        node.left?.next = if (node.right != null) node.right else findNext(node)
        node.right?.next = findNext(node)
        recursiveConnect(node.left)
        recursiveConnect(node.right)
    }

    private fun findNext(node: Node): Node? {
        var tmpNode = node.next
        while (tmpNode != null) {
            if (tmpNode.left != null) return tmpNode.left
            if (tmpNode.right != null) return tmpNode.right
            tmpNode = tmpNode.next
        }
        return null
    }

    companion object {
        class Node(var `val`: Int) {
            var left: Node? = null
            var right: Node? = null
            var next: Node? = null
        }
    }
}
