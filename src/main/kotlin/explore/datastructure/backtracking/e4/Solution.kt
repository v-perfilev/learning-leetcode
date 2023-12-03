package explore.datastructure.backtracking.e4

import kotlin.math.pow

class Solution {
    fun numsSameConsecDiff(n: Int, k: Int): IntArray {
        if (n == 0) return intArrayOf()
        val intList = mutableListOf<Int>()
        repeat(9) { backtracking(n, k, intList, mutableListOf(it + 1), it + 1) }
        return intList.toIntArray()
    }

    private fun backtracking(n: Int, k: Int, res: MutableList<Int>, list: MutableList<Int>, cur: Int) {
        if (list.size == n) {
            val resInt = intListToInt(list)
            res.add(resInt)
            return
        }
        if (k == 0) {
            list.add(cur)
            backtracking(n, k, res, list, cur)
            list.removeLast()
        } else {
            if (cur + k in 0..9) {
                list.add(cur + k)
                backtracking(n, k, res, list, cur + k)
                list.removeLast()
            }
            if (cur - k in 0..9) {
                list.add(cur - k)
                backtracking(n, k, res, list, cur - k)
                list.removeLast()
            }
        }
    }

    private fun intListToInt(list: List<Int>): Int =
        list
            .mapIndexed { index, value -> value * 10.toFloat().pow(list.size - index - 1).toInt() }
            .sum()
}
