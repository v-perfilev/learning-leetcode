package explore.binarysearch.e3

import java.lang.Exception

class Solution {
    fun guessNumber(n: Int): Int {
        var a = 0
        var b = n
        while (a <= b) {
            val pick = a + (b - a) / 2
            val result = guess(pick)
            if (result == 0) return pick
            if (result < 0) b = pick - 1
            else a = pick + 1
        }
        throw Exception()
    }

    fun guess(num: Int): Int = num
}
