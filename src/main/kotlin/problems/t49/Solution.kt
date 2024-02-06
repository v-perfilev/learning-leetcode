package problems.t49

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> =
        strs.groupBy { it.toCharArray().sorted().joinToString("") }.values.toList()
}
