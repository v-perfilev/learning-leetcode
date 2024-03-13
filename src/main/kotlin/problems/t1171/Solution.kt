package problems.t1171

class Solution {
    fun removeZeroSumSublists(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var current: ListNode? = dummy
        while (current != null) {
            var sum = 0
            var next = current.next
            while (next != null) {
                sum += next.`val`
                if (sum == 0) {
                    current.next = next.next
                }
                next = next.next
            }
            current = current.next
        }
        return dummy.next
    }

    companion object {
        class ListNode(var `val`: Int) {
            var next: ListNode? = null
        }
    }
}
