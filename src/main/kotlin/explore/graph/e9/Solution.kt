package explore.graph.e9

class Solution {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        if (graph.isEmpty()) return res
        dfs(graph, mutableListOf(), res, 0)
        return res
    }

    private fun dfs(graph: Array<IntArray>, path: MutableList<Int>, res: MutableList<List<Int>>, i: Int) {
        path.add(i)
        if (i == graph.size - 1) {
            res.add(ArrayList(path))
            return
        }
        graph[i].forEach {
            dfs(graph,path, res, it)
            path.removeLast()
        }
    }
}
