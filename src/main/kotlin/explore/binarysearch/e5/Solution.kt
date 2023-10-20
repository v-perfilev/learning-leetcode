package explore.binarysearch.e5

class Solution {
    fun firstBadVersion(n: Int): Int {
        var a = 0
        var b = n
        while (a < b) {
            val mid = a + (b - a) / 2
            if (isBadVersion(mid)) b = mid
            else a = mid + 1
        }
        return a
    }

    fun isBadVersion(version: Int): Boolean = true
}
