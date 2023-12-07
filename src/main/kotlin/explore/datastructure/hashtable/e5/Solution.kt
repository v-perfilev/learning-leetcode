package explore.datastructure.hashtable.e5

class Solution {
    fun largestUniqueNumber(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        nums.forEach { n -> map[n] = map.getOrDefault(n, 0) + 1 }
        return map.filter { (_, value) -> value == 1 }.keys.maxOrNull() ?: -1
    }
}
