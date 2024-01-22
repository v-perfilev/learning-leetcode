package problems.t1167

import java.util.PriorityQueue

class Solution {
    fun connectSticks(sticks: IntArray): Int {
        val pq = PriorityQueue<Int>()
        sticks.forEach { pq.offer(it) }
        var totalCost = 0
        while (pq.size > 1) {
            val cost = pq.poll() + pq.poll()
            pq.offer(cost)
            totalCost += cost
        }
        return totalCost
    }
}
