package problems.t3062

class Solution {
    fun gameResult(head: ListNode?): String {
        var node = head
        var counter = 0
        while (node != null) {
            if (node.`val` > node.next!!.`val`) counter++
            else if (node.`val` < node.next!!.`val`) counter--
            node = node.next!!.next
        }
        return when {
            counter > 0 -> "Even"
            counter < 0 -> "Odd"
            else -> "Tie"
        }
    }

    companion object {
        class ListNode(var `val`: Int) {
            var next: ListNode? = null
        }
    }
}
