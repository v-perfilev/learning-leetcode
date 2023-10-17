package explore.graph.e20

import java.util.PriorityQueue

class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val graph = createGraph(n + 1, times)
        val delayTimes = IntArray(n + 1) { if (it == k || it == 0) 0 else Int.MAX_VALUE }
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second }).apply { offer(Pair(k, 0)) }

        while (pq.isNotEmpty()) {
            val (node, time) = pq.poll()
            if (time > delayTimes[node]) continue
            graph[node].forEach { (destination, timeDiff) ->
                val newTime = time + timeDiff
                if (newTime < delayTimes[destination]) {
                    delayTimes[destination] = newTime
                    pq.offer(Pair(destination, newTime))
                }
            }
        }
        val maxDelay = delayTimes.max()
        return if (maxDelay == Int.MAX_VALUE) -1 else maxDelay
    }

    private fun createGraph(n: Int, edges: Array<IntArray>): Array<MutableList<Pair<Int, Int>>> {
        val graph = Array(n) { mutableListOf<Pair<Int, Int>>() }
        edges.forEach { (source, destination, time) ->
            graph[source].add(Pair(destination, time))
        }
        return graph
    }
}
