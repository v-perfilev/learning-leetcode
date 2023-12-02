package explore.datastructure.backtracking.e1

class Solution {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        if (graph.isEmpty()) return listOf()
        val res = mutableListOf<List<Int>>()
        backtracking(graph, res, mutableListOf(0), 0)
        return res
    }

    private fun backtracking(graph: Array<IntArray>, res: MutableList<List<Int>>, path: MutableList<Int>, cur: Int) {
        if (cur == graph.size - 1) {
            res.add(ArrayList(path))
            return
        }
        graph[cur].forEach {
            path.add(it)
            backtracking(graph, res, path, it)
            path.removeLast()
        }
    }
}
