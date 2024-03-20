package problems.t1669

class Solution {
    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
        var list1Head = list1
        var list2Tail = list2

        var i = 0
        while (i < a - 1) {
            list1Head = list1Head?.next
            i++
        }

        var j = 0
        var list1Tail = list1Head
        while (j < b - a + 1) {
            list1Tail = list1Tail?.next
            j++
        }

        while (list2Tail?.next != null) {
            list2Tail = list2Tail.next
        }

        list1Head?.next = list2
        list2Tail?.next = list1Tail?.next

        return list1
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
