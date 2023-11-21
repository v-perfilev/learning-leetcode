package problems.t1743

class Solution {
    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
        val map = buildMap(adjacentPairs)
        val first = findFirst(map)

        var res = IntArray(adjacentPairs.size + 1) { if (it == 0) first else 0 }
        for (i in 1..adjacentPairs.size) {
            val previous = if (i > 1) res[i - 2] else Int.MAX_VALUE
            val current = res[i - 1]
            res[i] = findNext(map, current, previous)
        }

        return res
    }

    private fun buildMap(adjacentPairs: Array<IntArray>): Map<Int, List<Int>> {
        val map = mutableMapOf<Int, MutableList<Int>>()
        adjacentPairs.forEach {
            val a = it[0]
            val b = it[1]
            if (map[a] == null) map[a] = mutableListOf()
            if (map[b] == null) map[b] = mutableListOf()
            map[a]!!.add(b)
            map[b]!!.add(a)
        }
        return map
    }

    private fun findFirst(map: Map<Int, List<Int>>): Int {
        return map.keys.find { map[it]!!.size == 1 }!!
    }

    private fun findNext(map: Map<Int, List<Int>>, current: Int, previous: Int): Int {
        for (value in map[current]!!) {
            if (value != previous) return value
        }
        throw Exception()
    }
}
