package explore.datastructure.treesgraphs.e14

class Solution {
    fun canReach(arr: IntArray, start: Int): Boolean {
        val graph = buildGraph(arr)
        return dfs(arr, graph, BooleanArray(arr.size), start)
    }

    private fun buildGraph(arr: IntArray): Array<IntArray> = arr.mapIndexed { index, value ->
        listOf(index - value, index + value).filter { it != index }.filter { it in arr.indices }.toIntArray()
    }.toTypedArray()

    private fun dfs(arr: IntArray, graph: Array<IntArray>, visited: BooleanArray, position: Int): Boolean {
        if (visited[position]) return false
        if (arr[position] == 0) return true
        visited[position] = true
        return graph[position].map { dfs(arr, graph, visited, it) }.any { it }
    }
}
