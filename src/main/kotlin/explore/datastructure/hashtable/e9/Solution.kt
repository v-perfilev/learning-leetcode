package explore.datastructure.hashtable.e9

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val letterSet = mutableSetOf<Char>()
        var max = 0
        var l = 0
        for (r in s.indices) {
            while (letterSet.contains(s[r])) letterSet.remove(s[l++])
            letterSet.add(s[r])
            max = maxOf(max, r - l + 1)
        }
        return max
    }
}
