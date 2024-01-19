package problems.t24

class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null) return null
        if (head.next == null) return head
        val next = head.next!!
        head.next = swapPairs(next.next)
        next.next = head
        return next
    }

    companion object {
        class ListNode(var `val`: Int) {
            var next: ListNode? = null
        }
    }
}
