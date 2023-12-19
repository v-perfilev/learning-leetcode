package problems.t1160

class Solution {
    fun countCharacters(words: Array<String>, chars: String): Int {
        val frequencyMap = chars.groupingBy { it }.eachCount()
        return words.filter { checkWord(frequencyMap, it) }.sumOf { it.length }
    }

    private fun checkWord(frequencyMap: Map<Char, Int>, word: String): Boolean {
        val wordFrequencyMap = word.groupingBy { it }.eachCount()
        return wordFrequencyMap.all { (c, count) -> frequencyMap.getOrDefault(c, 0) >= count }
    }
}
