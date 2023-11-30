package explore.datastructure.heap.e5

import java.util.PriorityQueue

class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val distanceSquares = IntArray(points.size) { points[it][0] * points[it][0] + points[it][1] * points[it][1] }
        val pq = PriorityQueue<Int>(Comparator.comparingInt { distanceSquares[it] })
            .apply { points.forEachIndexed { index, _ -> offer(index) } }
        return Array(k) { points[pq.poll()] }
    }
}
