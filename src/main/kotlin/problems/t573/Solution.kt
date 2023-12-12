package problems.t573

import kotlin.math.abs

class Solution {
    fun minDistance(height: Int, width: Int, tree: IntArray, squirrel: IntArray, nuts: Array<IntArray>): Int {
        val distances = nuts.map { calcDistance(tree, it) to calcDistance(squirrel, it) }
        val totalDistance = distances.sumOf { it.first } * 2
        return distances.minOf { totalDistance + it.second - it.first }
    }

    private fun calcDistance(a: IntArray, b: IntArray): Int = abs(a[0] - b[0]) + abs(a[1] - b[1])
}
