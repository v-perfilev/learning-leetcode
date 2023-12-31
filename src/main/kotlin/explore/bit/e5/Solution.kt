package explore.bit.e5

class Solution {
    fun getSum(a: Int, b: Int): Int {
        var result = 0
        var additionalBit = 0
        for (i in 0..31) {
            val bitSum = (a shr i and 1) + (b shr i and 1) + additionalBit
            val currentBit = if (bitSum == 1 || bitSum == 3) 1 else 0
            additionalBit = if (bitSum > 1) 1 else 0
            result = (currentBit shl i) xor result
        }
        return result
    }
}
