package explore.datastructure.treesgraphs.e7

class Solution {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val edgeMap = buildEdgeMap(n, edges)
        return dfs(edgeMap, BooleanArray(edgeMap.size), source, destination)
    }

    private fun buildEdgeMap(n: Int, edges: Array<IntArray>): Array<MutableSet<Int>> {
        val arr = Array<MutableSet<Int>>(n) { HashSet() }
        edges.forEach { (source, destination) ->
            arr[source].add(destination)
            arr[destination].add(source)
        }
        return arr
    }

    private fun dfs(edgeMap: Array<MutableSet<Int>>, visited: BooleanArray, source: Int, destination: Int): Boolean {
        if (source == destination) return true
        if (visited[source]) return false
        visited[source] = true
        edgeMap[source].forEach {
            if (dfs(edgeMap, visited, it, destination)) return true
        }
        return false
    }
}
