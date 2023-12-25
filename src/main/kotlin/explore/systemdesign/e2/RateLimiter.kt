package explore.systemdesign.e2

class RateLimiter(val n: Int, val t: Int) {
    private val container = ArrayDeque<Int>()

    fun shouldAllow(timestamp: Int): Boolean {
        while (container.isNotEmpty() && timestamp - container.first() >= t) container.removeFirst()
        if (container.size < n) {
            container.add(timestamp)
            return true
        }
        return false
    }
}
