package explore.datastructure.heap.e1

import java.util.PriorityQueue

class KthLargest(k: Int, nums: IntArray) {
    private val pq = PriorityQueue<Int>(Comparator.reverseOrder()).apply { nums.forEach { offer(it) } }
    private val pointer = k

    fun add(`val`: Int): Int {
        pq.add(`val`)
        while (pq.size > pointer) pq.poll()
        return pq.peek()
    }
}
