package explore.graph.e19

import java.util.PriorityQueue
import kotlin.math.abs

class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val edges = PriorityQueue<Edge>(Comparator.comparingInt { it.distance })
        val visited = BooleanArray(points.size) { it == 0 }
        addEdges(edges, visited, points, 0)
        var cost = 0
        var count = 0
        while (edges.isNotEmpty() && count < points.size - 1) {
            val edge = edges.poll()
            if (!visited[edge.p2]) {
                addEdges(edges, visited, points, edge.p2)
                visited[edge.p2] = true
                cost += edge.distance
                count++
            }
        }
        return cost
    }

    private fun addEdges(edges: PriorityQueue<Edge>, visited: BooleanArray, points: Array<IntArray>, p: Int) {
        val (x1, y1) = points[p]
        for (i in points.indices) {
            if (visited[i]) continue
            val (x2, y2) = points[i]
            val distance = calcDistance(x1, y1, x2, y2)
            edges.add(Edge(p, i, distance))
        }
    }

    private fun calcDistance(x1: Int, y1: Int, x2: Int, y2: Int): Int = abs(x1 - x2) + abs(y1 - y2)

    private data class Edge(val p1: Int, val p2: Int, val distance: Int)
}
