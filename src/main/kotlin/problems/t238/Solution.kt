package problems.t238

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val answers = IntArray(nums.size)
        var nonZeroMultiplication = 1
        var zeroCounter = 0
        nums.forEach { if (it != 0) nonZeroMultiplication *= it else zeroCounter++ }
        nums.forEachIndexed { index, it ->
            if (zeroCounter > 1 || (zeroCounter == 1 && it != 0)) answers[index] = 0
            else if (it == 0) answers[index] = nonZeroMultiplication else answers[index] = nonZeroMultiplication / it
        }
        return answers
    }
}
