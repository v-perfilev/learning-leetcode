package problems.t191

class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n: Int): Int {
        var counter = 0
        for (i in 0..31) {
            if ((n shr i) and 1 == 1) counter++
        }
        return counter
    }
}
