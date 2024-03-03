package problems.t19

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var fast: ListNode? = dummy
        var slow: ListNode? = dummy

        for (i in 1..n + 1) {
            fast = fast?.next
        }

        while (fast != null) {
            slow = slow?.next
            fast = fast.next
        }

        slow?.next = slow?.next?.next

        return dummy.next
    }

    companion object {
        class ListNode(var `val`: Int) {
            var next: ListNode? = null
        }
    }
}
