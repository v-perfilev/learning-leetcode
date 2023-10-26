package explore.dp.e17

class Solution {
    fun numDecodings(s: String): Int {
        val topDownRes = TopDownLetterDecoder().decode(s)
        println("Top down: $topDownRes")
        val bottomUpRes = BottomUpLetterDecoder().decode(s)
        println("Bottom up: $bottomUpRes")
        return bottomUpRes
    }

    companion object {
        interface LetterDecoder {
            fun decode(s: String): Int
        }

        /*
        TOP-DOWN
         */

        class TopDownLetterDecoder : LetterDecoder {
            private lateinit var s: String
            private lateinit var memo: IntArray

            override fun decode(s: String): Int {
                if (s[0] == '0') return 0
                this.s = s
                this.memo = IntArray(s.length) { -1 }
                return dp(0)
            }

            private fun dp(i: Int): Int {
                if (i > s.length) return 0
                if (i == s.length) return 1
                if (this.memo[i] == -1) {
                    if (this.s[i] == '0') {
                        this.memo[i] = 0
                    } else if (i < s.length - 1 && s.substring(i, i + 2).toInt() <= 26) {
                        this.memo[i] = dp(i + 1) + dp(i + 2)
                    } else {
                        this.memo[i] = dp(i + 1)
                    }
                }
                return this.memo[i]
            }
        }

        /*
        BOTTOM-UP
         */

        class BottomUpLetterDecoder : LetterDecoder {
            override fun decode(s: String): Int {
                if (s[0] == '0') return 0
                val memo = IntArray(s.length + 1) { if (it == s.length) 1 else 0 }
                for (i in s.length - 1 downTo 0) {
                    if (s[i] == '0') {
                        memo[i] = 0
                    } else if (i < s.length - 1 && s.substring(i, i + 2).toInt() <= 26) {
                        memo[i] = memo[i + 1] + memo[i + 2]
                    } else {
                        memo[i] = memo[i + 1]
                    }
                }
                return memo.first()
            }
        }
    }
}
