package problems.t1688

class Solution {
    fun numberOfMatches(n: Int): Int {
        var count = n
        var playedTotal = 0
        while (count > 1) {
            val playedCurrent = (count - count % 2) / 2
            count -= playedCurrent
            playedTotal += playedCurrent
        }
        return playedTotal
    }
}
