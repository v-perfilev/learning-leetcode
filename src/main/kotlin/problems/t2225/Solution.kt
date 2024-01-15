package problems.t2225

class Solution {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val loserMap = mutableMapOf<Int, Int>()
        matches.forEach { (winner, looser) ->
            loserMap.putIfAbsent(winner, 0)
            loserMap[looser] = loserMap.getOrDefault(looser, 0) + 1
        }
        val noLosePlayers = loserMap.filter { (_, value) -> value == 0 }.keys.sorted()
        val oneLosePlayers = loserMap.filter { (_, value) -> value == 1 }.keys.sorted()
        return listOf(noLosePlayers, oneLosePlayers)
    }
}
