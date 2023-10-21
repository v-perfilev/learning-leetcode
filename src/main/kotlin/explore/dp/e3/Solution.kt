package explore.dp.e3

class Solution {
    fun tribonacci(n: Int): Int {
        return BottomUpTribonacci().calc(n)
    }

    companion object {
        interface Tribonacci {
            fun calc(n: Int): Int
        }

        class BottomUpTribonacci : Tribonacci {
            override fun calc(n: Int): Int {
                if (n == 0) return 0
                if (n == 1) return 1
                if (n == 2) return 1
                var a = 0
                var b = 1
                var c = 1
                for (i in 3..n) {
                    val tmp = a + b + c
                    a = b
                    b = c
                    c = tmp
                }
                return c
            }
        }

        class TopDownTribonacci : Tribonacci {
            override fun calc(n: Int): Int {
                val cache = HashMap<Int, Int>()
                return calc(n, cache)
            }

            private fun calc(n: Int, cache: MutableMap<Int, Int>): Int {
                if (n == 0) return 0
                if (n == 1) return 1
                if (n == 2) return 1
                if (!cache.containsKey(n)) {
                    cache[n] = calc(n - 1, cache) + calc(n - 2, cache) + calc(n - 3, cache)
                }
                return cache[n]!!
            }
        }
    }
}
