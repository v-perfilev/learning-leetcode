package problems.t84

class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = ArrayDeque<Int>().apply { addLast(-1) }
        var max = 0
        for (i in heights.indices) {
            while (stack.last() != -1 && heights[stack.last()] >= heights[i]) {
                val currentHeight = heights[stack.removeLast()]
                val currentWidth = i - stack.last() - 1
                max = maxOf(max, currentHeight * currentWidth)
            }
            stack.addLast(i)
        }
        while (stack.last() != -1) {
            val currentHeight = heights[stack.removeLast()]
            val currentWidth = heights.size - stack.last() - 1
            max = maxOf(max, currentHeight * currentWidth)
        }
        return max
    }
}
