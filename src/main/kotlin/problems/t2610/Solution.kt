package problems.t2610

class Solution {
    fun findMatrix(nums: IntArray): List<List<Int>> {
        val map = mutableMapOf<Int, Int>()
        nums.forEach { map[it] = map.getOrDefault(it, 0) + 1 }
        val result = mutableListOf<List<Int>>()
        while (map.isNotEmpty()) {
            val list = mutableListOf<Int>()
            val keys = ArrayList(map.keys)
            for (num in keys) {
                list.add(num)
                map[num] = map[num]!! - 1
                if (map[num] == 0) map.remove(num)
            }
            result.add(list)
        }
        return result
    }
}
