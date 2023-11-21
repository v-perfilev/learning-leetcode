package problems.t1897

class Solution {
    fun makeEqual(words: Array<String>): Boolean {
        val frequencyMap = mutableMapOf<Char, Int>()
        words.forEach { w ->
            w.forEach { c ->
                frequencyMap.putIfAbsent(c, 0)
                frequencyMap[c] = frequencyMap[c]!! + 1
            }
        }
        for ((_, value) in frequencyMap) {
            if (value % words.size != 0) return false
        }
        return true
    }
}
