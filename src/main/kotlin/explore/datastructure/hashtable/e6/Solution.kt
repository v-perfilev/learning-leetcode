package explore.datastructure.hashtable.e6

class Solution {
    fun maxNumberOfBalloons(text: String): Int {
        val countMap = HashMap<Char, Int>(5)
        text.forEach { letter ->
            if (wordMap.containsKey(letter)) {
                countMap[letter] = countMap.getOrDefault(letter, 0) + 1
            }
        }
        var min = Int.MAX_VALUE
        wordMap.forEach { (letter, count) -> min = minOf(min, countMap.getOrDefault(letter, 0) / count) }
        return min
    }

    companion object {
        val wordMap = mapOf(
            'b' to 1,
            'a' to 1,
            'l' to 2,
            'o' to 2,
            'n' to 1,
        )
    }
}
