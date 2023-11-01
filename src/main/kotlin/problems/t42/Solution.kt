package problems.t42

class Solution {
    fun trap(height: IntArray): Int {
        var capacity = 0
        val max = findMax(height, 0, height.size - 1)
        val indexOfMax = findIndexMax(height, 0, height.size - 1, max)
        capacity += trapLeft(height, 0, indexOfMax - 1)
        capacity += trapRight(height, indexOfMax + 1, height.size - 1)
        return capacity
    }

    private fun trapLeft(height: IntArray, a: Int, b: Int): Int {
        if (b - a < 1) {
            return 0
        }
        var capacity = 0
        val localMax = findMax(height, a, b)
        val indexOfLocalMax = findIndexMax(height, a, b, localMax)
        capacity += trapLeft(height, a, indexOfLocalMax - 1)
        capacity += calcCapacity(height, indexOfLocalMax + 1, b, localMax)
        return capacity
    }

    private fun trapRight(height: IntArray, a: Int, b: Int): Int {
        if (b - a < 1) {
            return 0
        }
        var capacity = 0
        val localMax = findMax(height, a, b)
        val indexOfLocalMax = findIndexMax(height, a, b, localMax)
        capacity += calcCapacity(height, a, indexOfLocalMax - 1, localMax)
        capacity += trapRight(height, indexOfLocalMax + 1, b)
        return capacity
    }

    private fun calcCapacity(height: IntArray, a: Int, b: Int, max: Int): Int {
        var capacity = 0
        for (i in a..b) {
            capacity += max - height[i]
        }
        return capacity
    }

    private fun findMax(height: IntArray, a: Int, b: Int): Int {
        var max = 0
        for (i in a..b) {
            if (height[i] > max) {
                max = height[i]
            }
        }
        return max
    }

    private fun findIndexMax(height: IntArray, a: Int, b: Int, max: Int): Int {
        for (i in a..b) {
            if (height[i] == max) {
                return i
            }
        }
        throw Exception("max not found")
    }
}
