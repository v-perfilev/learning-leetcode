package explore.datastructure.hashtable.e1

class Solution {
    fun checkIfPangram(sentence: String): Boolean {
        val memo = BooleanArray(26)
        var counter = 0
        for (i in sentence.indices) {
            val charIndex = sentence[i].code - 97
            if (!memo[charIndex]) {
                memo[charIndex] = true
                counter++
            }
            if (counter == 26) return true
        }
        return false
    }
}
