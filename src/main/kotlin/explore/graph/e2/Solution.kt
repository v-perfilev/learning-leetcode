package explore.graph.e2

class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if (n - 1 != edges.size) return false
        val set = DisjointSet(n)
        edges.forEach {
            if (set.isConnected(it[0], it[1])) return false
            set.union(it[0], it[1])
        }
        return set.isValid()
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

            fun isConnected(x: Int, y: Int): Boolean = root[x] != x && root[y] != y && root[x] == root[y]

            fun isValid(): Boolean {
                var count = 0
                root.forEachIndexed { index, i -> if (i == index) count++ }
                return count == 1
            }
        }
    }
}
