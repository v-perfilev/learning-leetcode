package explore.datastructure.treesgraphs.e8

class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val edgeMap = buildEdgeMap(n, edges)
        val visited = BooleanArray(n)
        return IntArray(n) { it }.map { dfs(edgeMap, visited, it) }.sum()
    }

    private fun buildEdgeMap(n: Int, edges: Array<IntArray>): Array<MutableSet<Int>> {
        val arr = Array<MutableSet<Int>>(n) { HashSet() }
        edges.forEach { (source, destination) ->
            arr[source].add(destination)
            arr[destination].add(source)
        }
        return arr
    }

    private fun dfs(edgeMap: Array<MutableSet<Int>>, visited: BooleanArray, node: Int): Int {
        if (visited[node]) return 0
        visited[node] = true
        edgeMap[node].forEach {
            dfs(edgeMap, visited, it)
        }
        return 1
    }
}
