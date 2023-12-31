package explore.bit.e6

class Solution {
    fun grayCode(n: Int): List<Int> {
        val res = mutableListOf(0)
        for (i in 1..n) {
            val stepLength = res.size - 1
            val mask = 1 shl (i - 1)
            for (j in stepLength downTo 0) {
                res.add(mask + res[j])
            }
        }
        return res
    }
}
