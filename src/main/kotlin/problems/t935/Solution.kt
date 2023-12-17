package problems.t935

class Solution {
    private lateinit var memo: Array<Array<IntArray>>

    fun knightDialer(n: Int): Int {
        this.memo = Array(4) { Array(3) { IntArray(n) { -1 } } }
        return IntArray(12) { it }
            .map { it / 3 to it % 3 }
            .filter { !specialButtons.contains(it) }
            .map { (y, x) -> dp(y, x, n - 1) }
            .reduce { acc, sum -> (acc + sum) % MOD }
    }

    private fun dp(y: Int, x: Int, i: Int): Int {
        if (i == 0) return 1
        if (this.memo[y][x][i] == -1) {
            println("$y $x")
            this.memo[y][x][i] = directions
                .map { (dy, dx) -> y + dy to x + dx }
                .filter { (newY, newX) -> newY in 0..3 && newX in 0..2 }
                .filter { !specialButtons.contains(it) }
                .map { (newY, newX) -> dp(newY, newX, i - 1) }
                .reduceOrNull { acc, sum -> (acc + sum) % MOD } ?: 0
        }
        return this.memo[y][x][i]
    }

    companion object {
        private const val MOD = (1e9 + 7).toInt()

        private val specialButtons = setOf(
            3 to 0,
            3 to 2
        )

        private val directions = arrayOf(
            2 to -1,
            2 to 1,
            -2 to -1,
            -2 to 1,
            1 to -2,
            1 to 2,
            -1 to -2,
            -1 to 2,
        )
    }
}
