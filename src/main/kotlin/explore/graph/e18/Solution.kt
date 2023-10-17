package explore.graph.e18

import kotlin.math.abs

class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val edges = calcEdges(points)
        val disjointSet = DSU(points.size)
        return calcMinSpannedTreeCost(points.size, edges, disjointSet)
    }

    private fun calcEdges(points: Array<IntArray>): List<Edge> {
        val res = mutableListOf<Edge>()
        for (i in points.indices) {
            val (x1, y1) = points[i]
            for (j in i + 1..<points.size) {
                val (x2, y2) = points[j]
                val distance = calcDistance(x1, y1, x2, y2)
                res.add(Edge(i, j, distance))
            }
        }
        return res.sortedBy { it.distance }
    }

    private fun calcMinSpannedTreeCost(size: Int, edges: List<Edge>, disjointSet: DSU): Int {
        var minCost = 0
        var counter = 0
        for (edge in edges) {
            if (disjointSet.find(edge.p1) != disjointSet.find(edge.p2)) {
                disjointSet.union(edge.p1, edge.p2)
                minCost += edge.distance
                counter++
            }
            if (counter == size - 1) break
        }
        return minCost
    }

    private fun calcDistance(x1: Int, y1: Int, x2: Int, y2: Int): Int = abs(x1 - x2) + abs(y1 - y2)

    private class DSU(size: Int) {
        private val root = IntArray(size) { it }

        fun find(p: Int): Int {
            if (root[p] != p) root[p] = find(root[p])
            return root[p]
        }

        fun union(p1: Int, p2: Int) {
            root[find(p1)] = find(p2)
        }
    }

    private data class Edge(val p1: Int, val p2: Int, val distance: Int)
}
