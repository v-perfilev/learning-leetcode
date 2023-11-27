package explore.datastructure.treesgraphs.e10

class Solution {
    private lateinit var edgeMap: Array<MutableSet<Int>>
    private lateinit var visited: BooleanArray
    private lateinit var restricted: BooleanArray

    fun reachableNodes(n: Int, edges: Array<IntArray>, restricted: IntArray): Int {
        this.edgeMap = buildEdgeMap(n, edges)
        this.visited = BooleanArray(n)
        this.restricted = BooleanArray(n)
        restricted.forEach { this.restricted[it] = true }
        return dfs(0)
    }

    private fun buildEdgeMap(n: Int, edges: Array<IntArray>): Array<MutableSet<Int>> {
        val arr = Array<MutableSet<Int>>(n) { HashSet() }
        edges.forEach { (source, destination) ->
            arr[source].add(destination)
            arr[destination].add(source)
        }
        return arr
    }

    private fun dfs(n: Int): Int {
        if (visited[n] || restricted[n]) return 0
        visited[n] = true
        return 1 + edgeMap[n].sumOf { dfs(it) }
    }
}
