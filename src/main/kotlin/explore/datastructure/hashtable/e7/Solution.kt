package explore.datastructure.hashtable.e7

class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val letterMap = HashMap<Char, Int>()
        magazine.forEach { letter ->
            letterMap[letter] = letterMap.getOrDefault(letter, 0) + 1
        }
        ransomNote.forEach {letter ->
            if (letterMap.getOrDefault(letter, 0) == 0) return false
            letterMap[letter] = letterMap[letter]!! - 1
        }
        return true
    }
}
