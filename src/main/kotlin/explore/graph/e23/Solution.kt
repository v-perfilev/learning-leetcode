package explore.graph.e23

class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val res = ArrayList<Int>()
        val (graph, inDegrees) = createGraphAndInDegrees(numCourses, prerequisites)
        val queue = ArrayDeque<Int>().apply { addZeroInDegrees(inDegrees) }
        while (queue.isNotEmpty()) {
            val course = queue.removeFirst()
            if (inDegrees[course] != 0) break
            res.add(course)
            graph[course].forEach { c ->
                inDegrees[c]--
                if (inDegrees[c] == 0) queue.add(c)
            }
        }
        return if (res.size == numCourses) res.toIntArray() else IntArray(0)
    }

    private fun createGraphAndInDegrees(
        numCourses: Int,
        prerequisites: Array<IntArray>,
    ): Pair<Array<ArrayList<Int>>, IntArray> {
        val graph = Array(numCourses) { ArrayList<Int>() }
        val inDegrees = IntArray(numCourses)
        prerequisites.forEach { (course, prerequisite) ->
            graph[prerequisite].add(course)
            inDegrees[course]++
        }
        return graph to inDegrees
    }

    private fun ArrayDeque<Int>.addZeroInDegrees(inDegrees: IntArray) {
        inDegrees.forEachIndexed { index, value -> if (value == 0) this.add(index) }
    }
}
