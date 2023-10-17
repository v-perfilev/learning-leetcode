package explore.graph.e26

class Solution {
    fun minimumSemesters(n: Int, relations: Array<IntArray>): Int {
        val (graph, inDegrees) = createGraph(n, relations)
        val queue = initQueue(inDegrees)

        // Khan's algorithm
        var courseCounter = 0
        var semesterCounter = 0
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val course = queue.removeFirst()
                graph[course].forEach { next ->
                    inDegrees[next]--
                    if (inDegrees[next] == 0) queue.add(next)
                }
                courseCounter++
            }
            semesterCounter++
        }
        return if (courseCounter == n) semesterCounter else -1
    }

    private fun createGraph(n: Int, relations: Array<IntArray>): Pair<Array<HashSet<Int>>, IntArray> {
        val graph = Array(n + 1) { HashSet<Int>() }
        val inDegrees = IntArray(n + 1) { if (it == 0) Int.MAX_VALUE else 0 }
        relations.forEach { (prev, next) ->
            graph[prev].add(next)
            inDegrees[next]++
        }
        return graph to inDegrees
    }

    private fun initQueue(inDegrees: IntArray): ArrayDeque<Int> =
        ArrayDeque<Int>().apply {
            inDegrees.forEachIndexed { index, value ->
                if (value == 0) add(index)
            }
        }
}
