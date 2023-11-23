package explore.datastructure.stacksqueues.e2

class Solution {
    fun makeGood(s: String): String {
        val stack = ArrayDeque<Char>()
        s.forEach { c ->
            if (stack.isEmpty()) stack.addLast(c)
            else if (stack.last().code == c.code + 32 || stack.last().code == c.code - 32) stack.removeLast()
            else stack.addLast(c)
        }
        return stack.joinToString("")
    }
}
