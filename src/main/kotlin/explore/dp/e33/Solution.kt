package explore.dp.e33

class Solution {
    private lateinit var s1: String
    private lateinit var s2: String
    private lateinit var s3: String
    private lateinit var memo: Array<Array<Array<Boolean?>>>

    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if (s1.length + s2.length != s3.length) return false
        this.s1 = s1
        this.s2 = s2
        this.s3 = s3
        this.memo = Array(s1.length + 1) { Array(s2.length + 1) { Array(s3.length + 1) { null } } }
        return dp(0, 0, 0)
    }

    private fun dp(i1: Int, i2: Int, i3: Int): Boolean {
        if (this.s1.length == i1 && this.s2.length == i2) return true
        if (this.memo[i1][i2][i3] == null) {
            this.memo[i1][i2][i3] = false
            if (i1 < this.s1.length && this.s1[i1] == this.s3[i3]) {
                this.memo[i1][i2][i3] = this.memo[i1][i2][i3]!! || dp(i1 + 1, i2, i3 + 1)
            }
            if (i2 < this.s2.length && this.s2[i2] == this.s3[i3]) {
                this.memo[i1][i2][i3] = this.memo[i1][i2][i3]!! || dp(i1, i2 + 1, i3 + 1)
            }
        }
        return this.memo[i1][i2][i3]!!
    }
}
