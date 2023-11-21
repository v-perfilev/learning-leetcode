package problems.t1637

class Solution {
    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int =
        points.map { it[0] }
            .sorted()
            .windowed(size = 2, step = 1, partialWindows = false)
            .maxOf { it[1] - it[0] }
}
