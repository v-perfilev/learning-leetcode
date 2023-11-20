package explore.datastructure.linkedlist.e2

class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var slow = head
        var fast = head?.next
        while (fast != null) {
            if (slow!!.`val` == fast.`val`) {
                slow.next = fast.next
                fast = fast.next
            } else {
                slow = slow.next
                fast = fast.next
            }
        }
        return head
    }

    companion object {
        class ListNode(var `val`: Int) {
            var next: ListNode? = null
        }
    }
}
