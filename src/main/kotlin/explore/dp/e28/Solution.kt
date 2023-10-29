package explore.dp.e28

import kotlin.math.pow

class Solution {
    companion object {
        const val VOWEL_COUNT = 5
    }

    private lateinit var memo: Array<LongArray>
    private var n = 0

    fun countVowelPermutation(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 5
        this.memo = Array(n) { LongArray(VOWEL_COUNT + 1) }
        this.n = n
        var sum = 0L
        for (v in 1..VOWEL_COUNT) {
            sum += dp(1, v)
        }
        return mod(sum).toInt()
    }

    private fun dp(i: Int, v: Int): Long {
        if (i == this.n) return 1
        if (this.memo[i][v] == 0L) {
            val res = when (v) {
                1 -> dp(i + 1, 2)
                2 -> dp(i + 1, 1) + dp(i + 1, 3)
                3 -> dp(i + 1, 1) + dp(i + 1, 2) + dp(i + 1, 4) + dp(i + 1, 5)
                4 -> dp(i + 1, 3) + dp(i + 1, 5)
                else -> dp(i + 1, 1)
            }
            this.memo[i][v] = mod(res)
        }
        return this.memo[i][v]
    }

    private fun mod(value: Long): Long = value % (10.0.pow(9) + 7).toInt()
}
