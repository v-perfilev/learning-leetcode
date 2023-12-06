package explore.datastructure.hashtable.e4

class Solution {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val losMap = HashMap<Int, Int>()
        matches.forEach { (win, los) ->
            losMap.putIfAbsent(win, 0)
            val ll = losMap.getOrPut(los) { 0 }
            losMap[los] = ll + 1
        }
        val winners = losMap.filter { (_, value) -> value == 0 }.keys.sorted()
        val losers = losMap.filter { (_, value) -> value == 1 }.keys.sorted()
        return listOf(winners, losers)
    }
}
