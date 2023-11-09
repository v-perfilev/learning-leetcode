package problems.t189

class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        var counter = 0;
        var firstStep = 0;
        while (counter < nums.size) {
            var pointer = firstStep
            var firstHolder: Int
            var secondHolder = nums[pointer]
            do {
                val newPointer = (pointer + k).mod(nums.size)
                firstHolder = nums[newPointer]
                nums[newPointer] = secondHolder
                secondHolder = firstHolder
                pointer = newPointer
                counter++
            } while (pointer != firstStep)
            firstStep++
        }
    }
}
