package problems.t1436

class Solution {
    fun destCity(paths: List<List<String>>): String {
        val map = mutableMapOf<String, MutableList<String>>()
        paths.forEach {
            map.getOrPut(it[0]) {ArrayList()}.add(it[1])
            map.getOrPut(it[1]) {ArrayList()}
        }
        return map.keys.find { map[it]!!.isEmpty() }!!
    }
}
