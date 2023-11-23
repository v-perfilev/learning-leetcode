package explore.datastructure.stacksqueues.e1

class Solution {
    fun simplifyPath(path: String): String {
        val strList = pathToList(path)
        val stack = ArrayDeque<String>()
        for (str in strList) {
            if (stack.lastOrNull() == "/" && str == "/") continue
            if (stack.lastOrNull() == "/" && str == ".") continue
            if (stack.size == 1 && str == "..") continue
            if (stack.lastOrNull() == "/" && str == "..") {
                repeat(2) { stack.removeLast() }
                continue
            }
            stack.add(str)
        }
        while (stack.size > 1 && stack.last() == "/") stack.removeLast()
        return stack.joinToString("")
    }

    private fun pathToList(path: String): List<String> {
        val res = ArrayList<String>()
        var sb = StringBuilder()
        for (c in path) {
            if (c == '/' && sb.isEmpty()) {
                res.add(c.toString())
            } else if (c == '/' && sb.isNotEmpty()) {
                res.add(sb.toString())
                res.add(c.toString())
                sb = StringBuilder()
            } else {
                sb.append(c)
            }
        }
        if (sb.isNotEmpty()) res.add(sb.toString())
        return res
    }
}
