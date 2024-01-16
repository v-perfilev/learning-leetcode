package problems.t2741

class Solution {
    companion object {
        const val MOD = (1e9 + 7).toInt()
    }

    private lateinit var nums: IntArray
    private lateinit var memo: Array<IntArray>

    fun specialPerm(nums: IntArray): Int {
        this.nums = nums
        this.memo = Array(nums.size) { IntArray(1 shl nums.size) { -1 } }
        return dp(-1, 0)
    }

    private fun dp(i: Int, mask: Int): Int {
        if (mask == (1 shl nums.size) - 1) return 1
        if (i != -1 && this.memo[i][mask] != -1) return this.memo[i][mask]

        var count = 0
        for (j in this.nums.indices) {
            if ((1 shl j) and mask == 0 && (i == -1 || nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0)) {
                count = (count + dp(j, mask or (1 shl j))) % MOD
            }
        }

        if (i != -1) memo[i][mask] = count
        return count
    }
}
