package problems.t139

class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val pointers = BooleanArray(s.length + 1)
        pointers[s.length] = true
        for (i in s.length - 1 downTo 0) {
            for (j in wordDict.indices) {
                val substr = s.substring(i)
                val word = wordDict[j]
                if (i + word.length <= s.length
                    && pointers[i + word.length]
                    && s.substring(i, i + word.length) == word
                ) {
                    pointers[i] = true
                    break
                }
            }
        }
        return pointers[0]
    }
}
