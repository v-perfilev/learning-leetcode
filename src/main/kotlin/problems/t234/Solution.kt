package problems.t234

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        var slow: ListNode? = head!!
        var fast: ListNode? = head!!
        val stack = ArrayDeque<Int>().apply { add(slow!!.`val`) }

        while (fast != null) {
            stack.add(slow!!.`val`)
            if (fast.next == null) stack.removeLast()
            slow = slow.next
            fast = fast.next?.next
        }

        while (slow != null) {
            if (slow.`val` != stack.removeLast()) return false
            slow = slow.next
        }

        return true
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
