package explore.graph.e3

class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val set = DisjointSet(n)
        edges.forEach { set.union(it[0], it[1]) }
        return set.countComponents()
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

            fun countComponents(): Int {
                var count = 0
                root.forEachIndexed { index, i -> if (i == index) count++ }
                return count
            }
        }
    }
}
