package explore.datastructure.greedy.e4

import java.util.PriorityQueue

class Solution {
    fun minSetSize(arr: IntArray): Int {
        val map = HashMap<Int, Int>().also { arr.forEach { value -> it[value] = it.getOrPut(value) { 0 } + 1 } }
        val pq = PriorityQueue<Int>(Comparator.reverseOrder()).apply { map.values.forEach { offer(it) } }
        var sum = 0
        while (pq.isNotEmpty() && sum < arr.size / 2) sum += pq.poll()
        return map.size - pq.size
    }
}
