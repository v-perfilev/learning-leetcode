package explore.binarysearch.e12

class Solution {
    fun myPow(x: Double, n: Int): Double {
        if (x == 1.0 || n == 0) return 1.0
        return pow(x, n.toLong())
    }

    private fun pow(x: Double, n: Long): Double {
        return when {
            n == 1L -> x
            n < 0 -> 1L / pow(x, -n)
            n % 2 == 1L -> x * pow(x * x, (n - 1) / 2)
            else -> pow(x * x, n / 2)
        }
    }
}
