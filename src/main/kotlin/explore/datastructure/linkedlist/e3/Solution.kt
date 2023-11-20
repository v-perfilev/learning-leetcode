package explore.datastructure.linkedlist.e3

class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        var res = head
        var m = left
        var n = right

        if (res == null) {
            return null
        }

        var cur = res
        var prev: ListNode? = null
        while (m > 1) {
            prev = cur
            cur = cur!!.next
            m--
            n--
        }

        val con = prev
        val tail = cur

        var third: ListNode? = null
        while (n > 0) {
            third = cur!!.next
            cur.next = prev
            prev = cur
            cur = third
            n--
        }

        if (con != null) {
            con.next = prev
        } else {
            res = prev
        }

        tail!!.next = cur
        return res
    }

    companion object {
        class ListNode(var `val`: Int) {
            var next: ListNode? = null
        }
    }
}
