package explore.graph.e4

class Solution {
    fun earliestAcq(logs: Array<IntArray>, n: Int): Int {
        logs.sortBy { it[0] }
        val set = DisjointSet(n)
        logs.forEach {
            val size = set.union(it[1], it[2])
            if (size == 1) return it[0]
        }
        return -1
    }

    companion object {
        class DisjointSet(val size: Int) {
            private val root = IntArray(size) { it }
            private val rank = IntArray(size) { 1 }
            private var count = size

            fun find(x: Int): Int {
                if (x == root[x]) return x
                root[x] = find(root[x])
                return root[x]
            }

            fun union(x: Int, y: Int): Int {
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
                    count--
                }
                return count
            }
        }
    }
}
