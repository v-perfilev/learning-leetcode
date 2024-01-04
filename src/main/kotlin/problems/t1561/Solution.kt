package problems.t1561

class Solution {
    fun maxCoins(piles: IntArray): Int = piles
        .sortedArray()
        .drop(piles.size / 3)
        .windowed(size = 2, step = 2, partialWindows = false)
        .sumOf { it.first() }
}
