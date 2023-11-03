package problems.t65

class Solution {
    fun isNumber(s: String): Boolean {
        val regexList = listOf(
            Regex("^[+-]?\\d+([Ee][+-]?\\d+)?$"),
            Regex("^[+-]?\\d*\\.\\d+([Ee][+-]?\\d+)?$"),
            Regex("^[+-]?\\d+\\.\\d*([Ee][+-]?\\d+)?$")
        )
        return regexList.any { it.matches(s) }
    }
}
