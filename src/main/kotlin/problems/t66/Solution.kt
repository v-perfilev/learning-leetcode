package problems.t66

class Solution {
    fun plusOne(digits: IntArray): IntArray {
        val list = digits.reversed().toMutableList()
        var shouldIncrement = true
        var i = 0
        while (shouldIncrement) {
            if (i < list.size) {
                if (list[i] < 9) shouldIncrement = false
                list[i] = (list[i] + 1) % 10
                i++
            } else {
                list.add(1)
                shouldIncrement = false
            }
        }
        return list.reversed().toIntArray()
    }
}
