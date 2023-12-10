package problems.t296

import kotlin.math.abs

class Solution {
    fun minTotalDistance(grid: Array<IntArray>): Int {
        val friends = findFriends(grid)
        val meetingPoint = findMeetingPoint(friends)
        return friends.sumOf { calcManhattanDistance(it, meetingPoint) }
    }

    private fun findFriends(grid: Array<IntArray>): List<IntArray> {
        val friends = mutableListOf<IntArray>()
        for (j in grid.indices) {
            for (i in grid.first().indices) {
                if (grid[j][i] == 1) {
                    friends.add(intArrayOf(j, i))
                }
            }
        }
        return friends
    }

    private fun findMeetingPoint(friends: List<IntArray>): IntArray {
        val y = friends.map { it[0] }[friends.size / 2]
        val x = friends.map { it[1] }.sorted()[friends.size / 2]
        return intArrayOf(y, x)
    }

    private fun calcManhattanDistance(point1: IntArray, point2: IntArray): Int =
        abs(point1[0] - point2[0]) + abs(point1[1] - point2[1])
}
