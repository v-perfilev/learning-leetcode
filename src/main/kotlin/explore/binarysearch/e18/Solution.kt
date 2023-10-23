package explore.binarysearch.e18

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var l = 0
        var r = numbers.size - 1
        while (l < r) {
            val sum = numbers[l] + numbers[r]
            if (sum == target) return intArrayOf(l, r)
            else if (sum > target) r--
            else l++
        }
        return intArrayOf(-1, -1)
    }
}
