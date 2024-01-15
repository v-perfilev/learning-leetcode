package problems.t1165

import kotlin.math.abs

class Solution {
    fun calculateTime(keyboard: String, word: String): Int {
        val pointers = IntArray(26)
        keyboard.forEachIndexed { i, c -> pointers[c.code - 'a'.code] = i }
        var sum = 0
        var currentPointer = 0
        word.forEach {
            val newPointer = pointers[it.code - 'a'.code]
            sum += abs(currentPointer - newPointer)
            currentPointer = newPointer
        }
        return sum
    }
}
