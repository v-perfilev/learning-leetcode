package problems.t739

class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val res = IntArray(temperatures.size)
        val stack = ArrayDeque<Int>()
        for (i in temperatures.indices) {
            while (stack.isNotEmpty() && temperatures[stack.last()] < temperatures[i]) {
                val prev = stack.removeLast()
                res[prev] = i - prev
            }
            stack.addLast(i)
        }
        return res
    }
}
