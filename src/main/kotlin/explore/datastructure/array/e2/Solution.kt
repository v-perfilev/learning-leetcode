package explore.datastructure.array.e2

class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        if (nums.isEmpty()) return IntArray(0)
        val arr = IntArray(nums.size)
        var counter = 0
        var j = 0
        while (j < nums.size && nums[j] < 0) j++
        var i = j - 1
        while (i >= 0 || j < nums.size) {
            val left = if (i >= 0) nums[i] * nums[i] else Int.MAX_VALUE
            val right = if (j < nums.size) nums[j] * nums[j] else Int.MAX_VALUE
            if (left < right) {
                arr[counter] = left
                i--
            } else {
                arr[counter] = right
                j++
            }
            counter++
        }
        return arr
    }
}
