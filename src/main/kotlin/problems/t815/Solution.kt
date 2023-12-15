package problems.t815

import java.util.LinkedList

class Solution {
    fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
        if (source == target) return 0
        val routeMap = buildRouteMap(routes)
        val stopToVisitList = LinkedList<Int>().also { it.add(source) }
        val visitedStopSet = HashSet<Int>().also { it.add(source) }
        var changes = 0
        while (stopToVisitList.isNotEmpty()) {
            val size = stopToVisitList.size
            for (i in 0..<size) {
                val nextStop = stopToVisitList.removeFirst()
                if (nextStop == target) return changes
                routeMap[nextStop]!!.forEach {
                    if (!visitedStopSet.contains(it)) {
                        stopToVisitList.add(it)
                        visitedStopSet.add(it)
                    }
                }
            }
            changes++
        }
        return -1
    }

    private fun buildRouteMap(routes: Array<IntArray>): Map<Int, MutableSet<Int>> {
        val map = HashMap<Int, MutableSet<Int>>()
        routes.forEach { route ->
            route.forEach { stop ->
                map.getOrPut(stop) { HashSet() }.addAll(route.asList())
            }
        }
        return map
    }
}
