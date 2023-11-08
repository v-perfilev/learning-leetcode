package problems.t141

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        val addressSet = mutableSetOf<ListNode>()
        var node = head
        while (node != null) {
            if (!addressSet.add(node)) return true
            node = node.next
        }
        return false
    }

    companion object {
        class ListNode(var `val`: Int) {
            var next: ListNode? = null
        }
    }
}
