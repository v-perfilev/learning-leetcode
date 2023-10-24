package explore.dp.e10

class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val bottomUpRes = BottomUpWordBreaker().canBreakWords(s, wordDict)
        println("Bottom up: $bottomUpRes")
        val topDownRes = TopDownWordBreaker().canBreakWords(s, wordDict)
        println("Top down: $topDownRes")
        return topDownRes
    }

    companion object {
        interface WordBreaker {
            fun canBreakWords(s: String, wordDict: List<String>): Boolean
        }

        /*
        BOTTOM-UP
         */

        class BottomUpWordBreaker : WordBreaker {
            override fun canBreakWords(s: String, wordDict: List<String>): Boolean {
                val cache = BooleanArray(s.length + 1) { it == 0 }
                for (i in s.indices) {
                    if (cache[i]) {
                        wordDict.forEach {
                            if (i + it.length <= s.length && s.substring(i, i + it.length) == it) {
                                cache[i + it.length] = true
                            }
                        }
                    }
                }
                return cache[s.length]
            }
        }

        /*
        TOP-DOWN
         */

        class TopDownWordBreaker : WordBreaker {
            override fun canBreakWords(s: String, wordDict: List<String>): Boolean {
                val cache = Array<Boolean?>(s.length) { null }
                return dp(s, wordDict, cache, 0)
            }

            private fun dp(s: String, wordDict: List<String>, cache: Array<Boolean?>, i: Int): Boolean {
                if (i == s.length) return true
                if (i > s.length) return false
                if (cache[i] == null) {
                    cache[i] = false
                    for (word in wordDict) {
                        if (i + word.length <= s.length
                            && s.substring(i, i + word.length) == word
                            && dp(s, wordDict, cache, i + word.length)
                        ) {
                            cache[i] = true
                            break
                        }
                    }
                }
                return cache[i]!!
            }
        }
    }
}
