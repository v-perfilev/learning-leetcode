package explore.datastructure.treesgraphs.e16

class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        if (!wordList.contains(endWord)) return 0
        val words = mutableSetOf<String>().also {
            it.add(beginWord)
            it.addAll(wordList)
        }.toList()
        val graph = buildGraph(words)
        val queue = ArrayDeque<String>().apply { add(beginWord) }
        val visited = HashSet<String>().apply { add(beginWord) }
        var steps = 1
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val word = queue.removeFirst()
                if (word == endWord) return steps
                graph[word]!!
                    .filter { !visited.contains(it) }
                    .forEach {
                        queue.add(it)
                        visited.add(it)
                    }
            }
            steps++
        }
        return 0
    }

    private fun buildGraph(words: List<String>): Map<String, Set<String>> {
        val map = HashMap<String, HashSet<String>>()
        for (i in 0..<words.size - 1) {
            for (j in i + 1..<words.size) {
                map.getOrPut(words[i]) { HashSet() }
                map.getOrPut(words[j]) { HashSet() }
                if (areStringsAdjacent(words[i], words[j])) {
                    map[words[i]]!!.add(words[j])
                    map[words[j]]!!.add(words[i])
                }
            }
        }
        return map
    }

    private fun areStringsAdjacent(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) throw Exception()
        var differences = 0
        for (i in word1.indices) {
            if (word1[i] != word2[i]) differences++
        }
        return differences == 1
    }
}
