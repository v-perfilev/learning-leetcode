package problems.t2966

class Solution {
    companion object {
        const val SUB_ARR_SIZE = 3
    }

    fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
        if (nums.size % SUB_ARR_SIZE != 0) return arrayOf()

        val sortedNums = nums.sortedArray()
        val res = Array(nums.size / SUB_ARR_SIZE) { IntArray(SUB_ARR_SIZE) }

        sortedNums.forEachIndexed { index, num ->
            val subArrIdx = index / SUB_ARR_SIZE
            val elementIdx = index % SUB_ARR_SIZE
            if (elementIdx > 0 && num - res[subArrIdx][0] > k) return arrayOf()
            res[subArrIdx][elementIdx] = num
        }

        return res
    }
}

