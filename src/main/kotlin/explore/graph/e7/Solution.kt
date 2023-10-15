package explore.graph.e7

class Solution {
    fun minCostToSupplyWater(n: Int, wells: IntArray, pipes: Array<IntArray>): Int {
        val union = DisjointSetUnion(n + 1)
        val edges = mutableListOf<IntArray>()
            .also { it.addAll(pipes) }
            .also { wells.forEachIndexed { index, w -> it.add(intArrayOf(0, index + 1, w)) } }
            .sortedWith { a, b -> a[2].compareTo(b[2]) }

        var cost = 0
        for ((a, b, w) in edges) {
            if (union.union(a, b)) cost += w
            if (union.count() == 1) break
        }
        return cost
    }

    companion object {
        class DisjointSetUnion(val n: Int) {
            private val root = IntArray(n) { it }
            private val rank = IntArray(n) { 1 }
            private var count = n

            fun count(): Int {
                return count
            }

            fun find(x: Int): Int {
                if (root[x] != x) root[x] = find(root[x])
                return root[x]
            }

            fun union(x: Int, y: Int): Boolean {
                val (rootX, rootY) = find(x) to find(y)
                if (rootX == rootY) return false
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY
                } else {
                    root[rootY] = rootX
                    rank[rootX]++
                }
                count--
                return true
            }
        }
    }
}
