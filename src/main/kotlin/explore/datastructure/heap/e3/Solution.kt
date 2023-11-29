package explore.datastructure.heap.e3

import java.util.PriorityQueue

class Solution {
    fun connectSticks(sticks: IntArray): Int {
        val pq = PriorityQueue<Int>().apply { sticks.forEach { offer(it) } }
        var totalCost = 0
        while (pq.size > 1) {
            val cost = pq.poll() + pq.poll()
            pq.offer(cost)
            totalCost += cost
        }
        return totalCost
    }
}
