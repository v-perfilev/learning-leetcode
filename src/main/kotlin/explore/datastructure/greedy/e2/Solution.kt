package explore.datastructure.greedy.e2

import java.util.PriorityQueue

class Solution {
    fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
        val pq = PriorityQueue<Int>(Comparator.reverseOrder())
        boxTypes.forEach { boxType -> repeat(boxType[0]) { pq.offer(boxType[1]) } }
        var sum = 0
        repeat(truckSize) { if (pq.isNotEmpty()) sum += pq.poll() }
        return sum
    }
}
