package explore.dp.e6

import kotlin.math.max

class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val result1 = TopDownCommonSubsequenceFinder().calc(text1, text2)
        val result2 = BottomDownCommonSubsequenceFinder().calc(text1, text2)
        println("Top down result: $result1")
        println("Bottom up result: $result2")
        return result1
    }

    companion object {
        interface CommonSubsequenceFinder {
            fun calc(text1: String, text2: String): Int
        }

        class TopDownCommonSubsequenceFinder : CommonSubsequenceFinder {
            private lateinit var text1: String
            private lateinit var text2: String
            private lateinit var cache: Array<IntArray>

            override fun calc(text1: String, text2: String): Int {
                this.text1 = text1
                this.text2 = text2
                this.cache = Array(text1.length) { IntArray(text2.length) { -1 } }
                return dp(this.text1.length - 1, this.text2.length - 1)
            }

            private fun dp(i: Int, j: Int): Int {
                if (i < 0 || j < 0) return 0

                if (cache[i][j] == -1) {
                    if (this.text1[i] == this.text2[j]) {
                        cache[i][j] = dp(i - 1, j - 1) + 1
                    } else {
                        cache[i][j] = max(dp(i - 1, j), dp(i, j - 1))
                    }
                }

                return cache[i][j]
            }
        }

        class BottomDownCommonSubsequenceFinder : CommonSubsequenceFinder {
            override fun calc(text1: String, text2: String): Int {
                val cache = Array(text1.length + 1) { IntArray(text2.length + 1) }
                for (i in text1.indices) {
                    for (j in text2.indices) {
                        if (text1[i] == text2[j]) {
                            cache[i + 1][j + 1] = cache[i][j] + 1
                        } else {
                            cache[i + 1][j + 1] = max(cache[i][j + 1], cache[i + 1][j])
                        }
                    }
                }
                return cache[text1.length][text2.length]
            }
        }
    }
}
