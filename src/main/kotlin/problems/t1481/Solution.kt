package problems.t1481

class Solution {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        val values = arr.toList().groupingBy { it }.eachCount().values.sorted()
        var kLeft = k
        var i = 0
        while (kLeft > 0 && i < values.size) {
            kLeft -= values[i]
            if (kLeft >= 0) i++
        }
        return values.size - i
    }
}
