package problems.t60

class Solution {
    private lateinit var factorial: IntArray

    fun getPermutation(n: Int, k: Int): String {
        this.factorial = IntArray(n + 1) { -1 }
        calcFactorial(n)

        var restK = k - 1
        val set = (1..n).toSortedSet()
        val sb = StringBuilder()
        for (i in n - 1 downTo 0) {
            val f = factorial[i]
            val index = restK / f
            val num = set.elementAt(index)
            set.remove(num)
            sb.append(num)
            restK %= f
        }
        return sb.toString()
    }

    private fun calcFactorial(n: Int): Int {
        if (factorial[n] != -1) return factorial[n]
        if (n < 2) factorial[n] = 1
        else factorial[n] = n * calcFactorial(n - 1)
        return factorial[n]
    }
}
