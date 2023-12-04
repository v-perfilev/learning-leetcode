package explore.datastructure.bonus.e1

class Trie {
    private val nodes = HashMap<Char, Node>()

    fun insert(word: String) {
        if (word.isEmpty()) return
        var n = nodes.getOrPut(word[0]) { Node(word[0]) }
        if (word.length == 1) n.last = true
        for (i in 1..<word.length) {
            n = n.ancestors.getOrPut(word[i]) { Node(word[i]) }
            if (i == word.length - 1) n.last = true
        }
    }

    fun search(word: String): Boolean {
        if (word.isEmpty()) return false
        var n = nodes[word[0]] ?: return false
        for (i in 1..<word.length) {
            n = n.ancestors[word[i]] ?: return false
        }
        return n.last
    }

    fun startsWith(prefix: String): Boolean {
        if (prefix.isEmpty()) return false
        var n = nodes[prefix[0]] ?: return false
        for (i in 1..<prefix.length) {
            n = n.ancestors[prefix[i]] ?: return false
        }
        return true
    }

    companion object {
        private class Node(val c: Char) {
            val ancestors = HashMap<Char, Node>()
            var last = false
        }
    }
}
