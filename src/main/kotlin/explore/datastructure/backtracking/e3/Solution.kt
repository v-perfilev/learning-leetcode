package explore.datastructure.backtracking.e3

class Solution {
    fun generateParenthesis(n: Int): List<String> {
        if (n == 0) return emptyList()
        val res = mutableListOf<String>()
        backtracking(n, res, mutableListOf(), 0, 0)
        return res
    }

    private fun backtracking(n: Int, res: MutableList<String>, chars: MutableList<Char>, open: Int, close: Int) {
        if (open == close && open == n) {
            res.add(chars.joinToString(""))
            return
        }
        if (open < n) {
            chars.add('(')
            backtracking(n, res, chars, open + 1, close)
            chars.removeLast()
        }
        if (close < open) {
            chars.add(')')
            backtracking(n, res, chars, open, close + 1)
            chars.removeLast()
        }
    }
}
