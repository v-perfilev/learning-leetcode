package problems.t1464

class Solution {

    fun maxProduct(nums: IntArray): Int {
        val sortedNums = nums.sortedArray()
        val firstProduct = (sortedNums[0] - 1) * (sortedNums[1] - 1)
        val secondProduct = (sortedNums[sortedNums.size - 1] - 1) * (sortedNums[sortedNums.size - 2] - 1)
        return maxOf(firstProduct, secondProduct)
    }
}
