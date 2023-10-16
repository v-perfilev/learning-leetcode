package explore.binarytree.e11

class Solution {
    fun connect(root: Node?): Node? {
        if (root == null) return null
        recursiveConnect(root)
        return root
    }

    fun recursiveConnect(node: Node) {
        if (node.left == null) return

        node.left!!.next = node.right
        if (node.next != null) node.right!!.next = node.next!!.left

        recursiveConnect(node.left!!)
        recursiveConnect(node.right!!)
    }

    companion object {
        class Node(var `val`: Int) {
            var left: Node? = null
            var right: Node? = null
            var next: Node? = null
        }
    }
}
