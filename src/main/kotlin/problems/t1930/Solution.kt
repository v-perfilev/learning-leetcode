package problems.t1930

class Solution {
    fun countPalindromicSubsequence(s: String): Int = s
        .toSet()
        .asSequence()
        .map { s.indexOf(it) to s.lastIndexOf(it) }
        .filter { it.second - it.first > 1 }
        .map { s.substring(it.first + 1, it.second).toSet().size }
        .sum()
}
