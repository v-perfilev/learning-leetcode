package problems.t3063

class Solution {

    fun frequenciesOfElements(head: ListNode?): ListNode? {
        val firstNode = ListNode(1)
        var lastNode = firstNode
        val pointerMap = HashMap<Int, ListNode>().apply { set(head!!.`val`, firstNode) }

        var inputNode = head!!.next
        while (inputNode != null) {
            if (pointerMap.containsKey(inputNode.`val`)) {
                pointerMap[inputNode.`val`]!!.`val` += 1
            } else {
                val newNode = ListNode(1)
                lastNode.next = newNode
                lastNode = newNode
                pointerMap[inputNode.`val`] = newNode
            }
            inputNode = inputNode.next
        }

        return firstNode
    }

    companion object {
        class ListNode(var `val`: Int) {
            var next: ListNode? = null
        }
    }
}
