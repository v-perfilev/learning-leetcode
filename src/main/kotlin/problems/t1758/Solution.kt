package problems.t1758

class Solution {
    fun minOperations(s: String): Int {
        var counter = 0
        s.forEachIndexed { index, c ->
            if ((index) % 2 == c.code - 48) counter++
        }
        return minOf(counter, s.length - counter)
    }
}
