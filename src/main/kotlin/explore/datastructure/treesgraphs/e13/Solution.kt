package explore.datastructure.treesgraphs.e13

class Solution {
    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
        if (!bank.contains(endGene)) return -1
        val genes = mutableListOf<String>().apply {
            add(startGene)
            addAll(bank)
        }
        val graph = buildGraph(genes)
        val queue = ArrayDeque<String>().apply { add(startGene) }
        val visited = HashSet<String>().apply { add(startGene) }
        var steps = 0
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val gene = queue.removeFirst()
                if (gene == endGene) return steps
                graph[gene]!!
                    .filter { !visited.contains(it) }
                    .forEach {
                        queue.add(it)
                        visited.add(it)
                    }
            }
            steps++
        }
        return -1
    }

    private fun buildGraph(genes: List<String>): Map<String, Set<String>> {
        val map = HashMap<String, HashSet<String>>()
        for (i in 0..<genes.size - 1) {
            for (j in i + 1..<genes.size) {
                if (areGenesAdjacent(genes[i], genes[j])) {
                    map.getOrPut(genes[i]) { HashSet() }.add(genes[j])
                    map.getOrPut(genes[j]) { HashSet() }.add(genes[i])
                }
            }
        }
        return map
    }

    private fun areGenesAdjacent(gene1: String, gene2: String): Boolean {
        if (gene1.length != gene2.length) throw Exception()
        var differences = 0
        for (i in gene1.indices) {
            if (gene1[i] != gene2[i]) differences++
        }
        return differences == 1
    }
}
