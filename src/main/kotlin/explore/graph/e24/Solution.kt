package explore.graph.e24

class Solution {
    private lateinit var graph: MutableMap<Char, MutableSet<Char>>
    private lateinit var inDegree: MutableMap<Char, Int>

    fun alienOrder(words: Array<String>): String {
        graph = HashMap()
        inDegree = HashMap()
        initGraph(words)
        if (!fillGraph(words)) return ""
        val res = khanSort()
        return if (res.length == inDegree.size) res else ""
    }

    private fun initGraph(words: Array<String>) {
        words.forEach { word ->
            word.forEach { char ->
                if (char !in graph) {
                    graph[char] = HashSet()
                    inDegree[char] = 0
                }
            }
        }
    }

    private fun fillGraph(words: Array<String>): Boolean {
        for (i in 0..words.size - 2) {
            val w1 = words[i]
            val w2 = words[i + 1]
            if (w1.length > w2.length && w1.startsWith(w2)) return false
            for (j in 0..<minOf(w1.length, w2.length)) {
                val c1 = w1[j]
                val c2 = w2[j]
                if (c1 != c2) {
                    if (c2 !in graph[c1]!!) {
                        graph[c1]!!.add(w2[j])
                        inDegree[c2] = inDegree[c2]!! + 1
                    }
                    break
                }
            }
        }
        return true
    }

    private fun khanSort(): String {
        val queue = ArrayDeque<Char>()
        inDegree.filter { it.value == 0 }.forEach { queue.add(it.key) }
        val sb = StringBuilder()
        while (queue.isNotEmpty()) {
            val c1 = queue.removeFirst()
            sb.append(c1)
            graph[c1]!!.forEach { c2 ->
                inDegree[c2] = inDegree[c2]!! - 1
                if (inDegree[c2] == 0) queue.add(c2)
            }
        }
        return sb.toString()
    }
}
