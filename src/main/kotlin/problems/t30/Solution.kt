package problems.t30

class Solution {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val wordMap = mutableMapOf<String, Int>()
        val wordTargetMap = mutableMapOf<String, Int>()
        words.forEach {
            wordMap[it] = 0
            wordTargetMap[it] = wordTargetMap.getOrDefault(it, 0) + 1
        }

        val result = mutableListOf<Int>()
        var a = 0
        var b = 0
        val step = words[0].length
        while (b <= s.length - step) {
            val wordB = s.substring(b, b + step)
            if (wordMap.containsKey(wordB)) wordMap[wordB] = wordMap[wordB]!! + 1
            while (b - a > (words.size - 1) * step) {
                val wordA = s.substring(a, a + step)
                if (wordMap.containsKey(wordA)) wordMap[wordA] = wordMap[wordA]!! - 1
                a++
            }
            if (b - a == (words.size - 1) * step
                && wordMap.keys.all { wordMap[it] == wordTargetMap[it] }
            ) result.add(a)
            b++
        }

        return result
    }
}
