package explore.datastructure.hashtable.e10

class Solution {
    fun findMaxLength(nums: IntArray): Int {
        val map = mutableMapOf(0 to -1)
        var max = 0
        var count = 0
        nums.forEachIndexed { i, n ->
            count += if (n == 1) 1 else -1
            if (map.containsKey(count)) max = maxOf(max, i - map[count]!!)
            else map[count] = i
        }
        return max
    }
}
