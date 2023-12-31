package explore.bit.e3

class Solution {
    fun hammingWeight(n: Int): Int {
        var counter = 0
        for (i in 0..31) {
            if ((n shr i) and 1 == 1) counter++
        }
        return counter
    }
}
