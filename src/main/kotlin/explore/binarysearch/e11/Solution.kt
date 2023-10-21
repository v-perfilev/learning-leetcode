package explore.binarysearch.e11

class Solution {
    fun search(reader: ArrayReader, target: Int): Int {
        var (a, b) = findLength(reader, target)
        while (a <= b) {
            val mid = a + (b - a) / 2
            if (reader.get(mid) == target) return mid
            if (reader.get(mid) < target) a = mid + 1
            else b = mid - 1
        }
        return -1
    }

    private fun findLength(reader: ArrayReader, target: Int): Pair<Int, Int> {
        var guess = 2
        var prevGuess = 0
        while (reader.get(guess) < target) {
            prevGuess = guess
            guess *= 2
        }
        return Pair(prevGuess, guess)
    }

    companion object {
        class ArrayReader(private val arr: IntArray) {
            fun get(index: Int): Int = if (index >= arr.size) Int.MAX_VALUE else arr[index]
        }
    }
}
