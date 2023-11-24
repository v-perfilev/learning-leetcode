package explore.datastructure.stacksqueues.e4

class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val map = HashMap<Int, Int>()
        val stack = ArrayDeque<Int>()
        for (i in nums2.indices) {
            while (stack.isNotEmpty() && nums2[i] > nums2[stack.last()]) {
                map[nums2[stack.removeLast()]] = nums2[i]
            }
            stack.add(i)
        }
        return nums1.map { map[it] ?: -1 }.toIntArray()
    }
}
