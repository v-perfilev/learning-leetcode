package problems.t451

class Solution {
    fun frequencySort(s: String): String =
        s.groupingBy { it }.eachCount().toList()
            .sortedByDescending { it.second }
            .joinToString("") { it.first.toString().repeat(it.second) }
}
