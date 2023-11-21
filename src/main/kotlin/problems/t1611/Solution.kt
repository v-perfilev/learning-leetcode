package problems.t1611

class Solution {
    fun minimumOneBitOperations(n: Int): Int {
        var ans = 0
        var k = 0
        var mask = 1

        while (mask <= n) {
            if (n and mask !== 0) {
                ans = (1 shl k + 1) - 1 - ans
            }
            mask = mask shl 1
            k++
        }

        return ans
    }

    private fun Int.toByteArray(): BooleanArray = Integer.toBinaryString(this).map { it == '1' }.toBooleanArray()
}
