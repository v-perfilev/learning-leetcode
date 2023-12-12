package problems.t588

class FileSystem() {
    private val root = Node("")

    fun ls(path: String): List<String> {
        val pathPair = getPath(path)
        return if (pathPair.second.isNotEmpty()) {
            var parentNode = root
            pathPair.first.forEach { pathPart ->
                parentNode = parentNode.children!![pathPart]!!
            }
            val node = parentNode.children!![pathPair.second]!!
            if (node.isFile) listOf(node.name)
            else node.children!!.keys.sorted()
        } else {
            root.children!!.keys.sorted()
        }
    }

    fun mkdir(path: String) {
        val pathPair = getPath(path)
        var parentNode = root
        pathPair.first.forEach { pathPart ->
            parentNode = parentNode.children!!.getOrPut(pathPart) { Node(pathPart) }
        }
        parentNode.children!![pathPair.second] = Node(pathPair.second)
    }

    fun addContentToFile(filePath: String, content: String) {
        val pathPair = getPath(filePath)
        var parentNode = root
        pathPair.first.forEach { pathPart ->
            parentNode = parentNode.children!!.getOrPut(pathPart) { Node(pathPart) }
        }
        val node = parentNode.children!!.getOrPut(pathPair.second) { Node(pathPair.second, "") }
        node.content += content
    }

    fun readContentFromFile(filePath: String): String {
        val pathPair = getPath(filePath)
        var parentNode = root
        pathPair.first.forEach { pathPart ->
            parentNode = parentNode.children!![pathPart]!!
        }
        return parentNode.children!![pathPair.second]!!.content!!
    }

    private fun getPath(path: String): Pair<List<String>, String> {
        val fullList = path.split("/")
        val list = if (fullList.size > 2) fullList.subList(1, fullList.size - 1) else listOf()
        val file = fullList.last()
        return list to file
    }

    companion object {
        class Node {
            val name: String
            val isFile: Boolean
            var content: String? = null
            var children: MutableMap<String, Node>? = null

            constructor(name: String) {
                this.name = name
                this.isFile = false
                this.children = mutableMapOf()
            }

            constructor(name: String, content: String) {
                this.name = name
                this.isFile = true
                this.content = content
            }
        }
    }
}
