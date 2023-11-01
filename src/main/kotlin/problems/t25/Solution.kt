package problems.t25

class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null || k == 1) return head
        var node = head
        var count = 0
        while (node != null && count != k) {
            node = node.next
            count++
        }
        if (count == k) {
            val nextListHead = reverseKGroup(node, k)
            var curr: ListNode? = head
            var prev: ListNode? = null
            while (count > 0) {
                val nextNode = curr!!.next
                curr.next = prev
                prev = curr
                curr = nextNode
                count--
            }
            curr!!.next = nextListHead
            return prev
        }
        return head
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
