package explore.binarysearch.e9

class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        var (a, b) = 0 to arr.size - k
        while (a + 1 < b) {
            val mid = a + (b - a) / 2
            if (x - arr[mid] >= arr[mid + k - 1] - x) a = mid
            else b = mid
        }
        return arr.slice(a..<a + k)
    }
}
