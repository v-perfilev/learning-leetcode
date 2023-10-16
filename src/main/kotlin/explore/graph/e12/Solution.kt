package explore.graph.e12

class Solution {
    fun leadsToDestination(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val graphMap = buildGraphMap(n, edges)
        if (graphMap[destination]!!.isNotEmpty()) return false
        return dfs(graphMap, mutableSetOf(), mutableSetOf(), source, destination)
    }

    private fun buildGraphMap(n: Int, edges: Array<IntArray>): Map<Int, List<Int>> {
        val map = mutableMapOf<Int, MutableList<Int>>()
        for (i in 0..<n) {
            map[i] = mutableListOf()
        }
        edges.forEach { (source, destination) ->
            map[source]!!.add(destination)
        }
        return map
    }

    private fun dfs(
        graphMap: Map<Int, List<Int>>,
        visitingNodeSet: MutableSet<Int>,
        visitedNodeSet: MutableSet<Int>,
        location: Int,
        destination: Int
    ): Boolean {
        if (location == destination) return true
        if (graphMap[location]!!.isEmpty()) return false
        if (visitingNodeSet.contains(location)) return visitedNodeSet.contains(location)
        visitingNodeSet.add(location)
        graphMap[location]!!.forEach {
            if (!dfs(graphMap, visitingNodeSet, visitedNodeSet, it, destination)) return false
        }
        visitedNodeSet.add(location)
        return true
    }
}
