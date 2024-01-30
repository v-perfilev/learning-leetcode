package problems.t150

class Solution {
    companion object {
        val OPERATORS = setOf("+", "-", "*", "/")
    }

    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        tokens.forEach {
            if (it in OPERATORS) {
                val val2 = stack.removeLast()
                val val1 = stack.removeLast()
                val res = when (it) {
                    "+" -> val1 + val2
                    "-" -> val1 - val2
                    "*" -> val1 * val2
                    else -> val1 / val2
                }
                stack.addLast(res)
            } else {
                stack.addLast(it.toInt())
            }
        }
        return stack.removeFirst()
    }
}
