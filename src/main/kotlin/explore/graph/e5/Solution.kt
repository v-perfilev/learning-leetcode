package explore.graph.e5

class Solution {
    fun smallestStringWithSwaps(s: String, pairs: List<List<Int>>): String {
        val set = DisjointSet(s.length)
        pairs.forEach { set.union(it[0], it[1]) }
        val map = mutableMapOf<Int, MutableList<Int>>()
        for (i in s.indices) {
            val root = set.find(i)
            map.getOrPut(root) { mutableListOf() }.add(i)
        }
        val str = CharArray(s.length)
        map.values.forEach { vertexes ->
            val charList = mutableListOf<Char>()
            vertexes.forEach { vertex ->
                charList.add(s[vertex])
            }
            charList.sort()

            for (i in vertexes.indices) {
                str[vertexes[i]] = charList[i]
            }
        }
        return str.joinToString("")
    }

    companion object {
        class DisjointSet(val size: Int) {
            private val root = IntArray(size) { it }
            private val rank = IntArray(size) { 1 }

            fun find(x: Int): Int {
                if (x == root[x]) return x
                root[x] = find(root[x])
                return root[x]
            }

            fun union(x: Int, y: Int) {
                val rootX = find(x)
                val rootY = find(y)
                if (rootX != rootY) {
                    if (rank[rootX] > rank[rootY]) {
                        root[rootY] = rootX
                    } else if (rank[rootX] < rank[rootY]) {
                        root[rootX] = rootY
                    } else {
                        root[rootY] = rootX
                        rank[rootX]++
                    }
                }
            }
        }
    }
}
