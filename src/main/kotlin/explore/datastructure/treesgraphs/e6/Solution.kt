package explore.datastructure.treesgraphs.e6

class Solution {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        root ?: return TreeNode(`val`)
        if (root.`val` > `val`) root.left = insertIntoBST(root.left, `val`)
        else root.right = insertIntoBST(root.right, `val`)
        return root
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

