package problems.t1846

class Solution {
    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        arr.sort()
        for (i in arr.indices) {
            if (i == 0) arr[i] = 1
            else if (arr[i] - arr[i - 1] > 1) arr[i] = arr[i - 1] + 1
        }
        return arr.last()
    }
}
