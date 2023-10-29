package explore.dp.e29

class Solution {
    private lateinit var memo: Array<IntArray>
    private lateinit var nums1: IntArray
    private lateinit var nums2: IntArray

    fun findLength(nums1: IntArray, nums2: IntArray): Int {
        this.memo = Array(nums1.size) { IntArray(nums2.size) { -1 } }
        this.nums1 = nums1
        this.nums2 = nums2
        var max = 0
        for (i in this.nums1.indices) {
            for (j in this.nums2.indices) {
                max = maxOf(max, dp(i, j))
            }
        }
        return max
    }

    private fun dp(i: Int, j: Int): Int {
        if (i == this.nums1.size || j == this.nums2.size) return 0
        if (this.memo[i][j] == -1) {
            this.memo[i][j] = if (this.nums1[i] == this.nums2[j]) 1 else 0
            this.memo[i][j] += dp(i + 1, j + 1)
        }
        return this.memo[i][j]
    }
}
