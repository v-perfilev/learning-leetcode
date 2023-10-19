package explore.binarysearch.e4

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val shift = findShift(nums)
        var a = shift
        var b = nums.size + shift - 1
        while (a <= b) {
            val mid = a + (b - a) / 2
            if (nums.getShifted(mid) == target) return nums.getShiftedIndex(mid)
            if (nums.getShifted(mid) > target) b = mid - 1
            else a = mid + 1
        }
        return -1
    }

    private fun findShift(nums: IntArray): Int {
        var a = 0
        var b = nums.size - 1
        while (a <= b) {
            val mid = a + (b - a) / 2
            if (nums[mid] > nums[nums.size - 1]) a = mid + 1
            else b = mid - 1
        }
        return a
    }

    private fun IntArray.getShiftedIndex(index: Int): Int {
        return if (index >= this.size) index - this.size else index
    }

    private fun IntArray.getShifted(index: Int): Int {
        return if (index >= this.size) this[index - this.size] else this[index]
    }
}
