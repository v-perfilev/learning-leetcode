package explore.datastructure.heap.e2

import java.util.PriorityQueue

class Solution {
    fun minStoneSum(piles: IntArray, k: Int): Int {
        val pq = PriorityQueue<Int>(Comparator.reverseOrder()).apply { piles.forEach { offer(it) } }
        repeat(k) {
            val biggestPile = pq.poll()
            val flooredPile = if (biggestPile % 2 == 1) biggestPile / 2 + 1 else biggestPile / 2
            pq.offer(flooredPile)
        }
        return pq.sum()
    }
}
