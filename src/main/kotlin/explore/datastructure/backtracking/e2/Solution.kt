package explore.datastructure.backtracking.e2

class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        val res = mutableListOf<String>()
        backtracking(digits, res, mutableListOf(), 0)
        return res
    }

    private fun backtracking(digits: String, res: MutableList<String>, str: MutableList<Char>, cur: Int) {
        if (cur == digits.length) {
            res.add(str.joinToString(""))
            return
        }
        letterMap[digits[cur]]!!.forEach {
            str.add(it)
            backtracking(digits, res, str, cur + 1)
            str.removeLast()
        }
    }

    companion object {
        private val letterMap = mapOf(
            '2' to listOf('a', 'b', 'c'),
            '3' to listOf('d', 'e', 'f'),
            '4' to listOf('g', 'h', 'i'),
            '5' to listOf('j', 'k', 'l'),
            '6' to listOf('m', 'n', 'o'),
            '7' to listOf('p', 'q', 'r', 's'),
            '8' to listOf('t', 'u', 'v'),
            '9' to listOf('w', 'x', 'y', 'z')
        )
    }
}
