package problems.t1662

class Solution {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        var w1Idx = 0
        var w2Idx = 0
        var l1Idx = 0
        var l2Idx = 0
        while (w1Idx < word1.size && w2Idx < word2.size) {
            if (word1[w1Idx][l1Idx] != word2[w2Idx][l2Idx]) return false
            l1Idx++
            l2Idx++
            if (l1Idx == word1[w1Idx].length) {
                w1Idx++
                l1Idx = 0
            }
            if (l2Idx == word2[w2Idx].length) {
                w2Idx++
                l2Idx = 0
            }
        }
        return w1Idx == word1.size && w2Idx == word2.size
    }
}
