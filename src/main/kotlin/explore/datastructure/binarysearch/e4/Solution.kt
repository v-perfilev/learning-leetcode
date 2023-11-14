package explore.datastructure.binarysearch.e4

class Solution {
    fun maximizeSweetness(sweetness: IntArray, k: Int): Int {
        val totalK = k + 1
        var left = sweetness.min()
        var right = sweetness.sum()
        while (left < right) {
            val mid = left + (right - left + 1) / 2
            var cur = 0
            var people = 0
            sweetness.forEach {
                cur += it
                if (cur >= mid) {
                    people++
                    cur = 0
                }
            }
            if (people >= totalK) left = mid
            else right = mid - 1
        }
        return left
    }
}
