package problems.t948

class Solution {
    fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
        val sortedTokens = tokens.sortedArray()
        var currentPower = power
        var a = 0
        var b = sortedTokens.size - 1
        var maxScore = 0
        var score = 0
        while (a <= b) {
            if (currentPower >= sortedTokens[a]) {
                currentPower -= sortedTokens[a]
                a++
                score++
                maxScore = maxScore.coerceAtLeast(score)
            } else if (score > 0) {
                currentPower += sortedTokens[b]
                b--
                score--
            } else {
                break
            }
        }
        return maxScore
    }
}
