package problems.t23

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        if (lists.size == 1) return lists[0]
        var list1 = mergeKLists(lists.copyOfRange(0, lists.size / 2))
        var list2 = mergeKLists(lists.copyOfRange(lists.size / 2, lists.size))
        var root: ListNode?
        takeNext(list1, list2).let { container ->
            root = container.min?.let { ListNode(it) }
            list1 = container.list1
            list2 = container.list2
        }
        var node = root
        while (list1 != null || list2 != null) {
            takeNext(list1, list2).let { container ->
                node!!.next = container.min?.let { ListNode(it) }
                list1 = container.list1
                list2 = container.list2
                node = node?.next
            }
        }
        return root
    }

    private fun takeNext(list1: ListNode?, list2: ListNode?): ListContainer {
        return if (list1 != null && list2 != null) {
            if (list1.`val` < list2.`val`) {
                ListContainer(list1.next, list2, list1.`val`)
            } else {
                ListContainer(list1, list2.next, list2.`val`)
            }
        } else if (list1 != null) {
            ListContainer(list1.next, null, list1.`val`)
        } else if (list2 != null) {
            ListContainer(null, list2.next, list2.`val`)
        } else ListContainer(null, null, null)
    }

    companion object {
        data class ListContainer(val list1: ListNode?, val list2: ListNode?, val min: Int?)

        class ListNode(var `val`: Int) {
            var next: ListNode? = null
        }
    }
}
