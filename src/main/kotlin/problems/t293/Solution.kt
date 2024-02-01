package problems.t293

class Solution {
    fun generatePossibleNextMoves(currentState: String): List<String> {
        if (currentState.length < 2) return listOf()
        val res = mutableListOf<String>()
        for (i in 0..currentState.length - 2) {
            if (currentState[i] == '+' && currentState[i] == currentState[i + 1]) {
                val sb = StringBuilder(currentState)
                sb.setCharAt(i, '-')
                sb.setCharAt(i + 1, '-')
                res.add(sb.toString())
            }
        }
        return res
    }
}
