package problems.t383

class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val letterMap = buildMap(magazine)
        ransomNote.forEach {
            if (!letterMap.containsKey(it) || letterMap[it]!! <= 0) return false
            letterMap[it] = letterMap[it]!! - 1
        }
        return true
    }

    private fun buildMap(magazine: String): MutableMap<Char, Int> {
        val map = mutableMapOf<Char,Int>()
        magazine.forEach { if (map.containsKey(it)) map[it] = map[it]!! + 1 else map[it] = 1 }
        return map
    }
}
