package problems.t1877

class Solution {
    fun minPairSum(nums: IntArray?): Int {
        val arr = nums!!.sortedArray()
        var max = Int.MIN_VALUE
        for (i in 0..<arr.size / 2) {
            val sum = arr[i] + arr[arr.size - i]
            if (sum > max) max = sum
        }
        return max
    }
}
