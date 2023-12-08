package explore.datastructure.hashtable.e8

class Solution {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        val jewelSet = jewels.toSet()
        return stones.filter { jewelSet.contains(it) }.count()
    }
}
