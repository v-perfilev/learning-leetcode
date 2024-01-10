package problems.t872

class Solution {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()
        fillSequence(list1, root1!!)
        fillSequence(list2, root2!!)
        return list1 == list2
    }

    private fun fillSequence(list: MutableList<Int>, node: TreeNode) {
        if (node.left != null) fillSequence(list, node.left!!)
        if (node.right != null) fillSequence(list, node.right!!)
        if (node.left == null && node.right == null) list.add(node.`val`)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
