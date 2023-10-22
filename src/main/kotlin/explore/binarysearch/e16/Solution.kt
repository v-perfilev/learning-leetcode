package explore.binarysearch.e16

class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val set1 = nums1.toHashSet()
        val set2 = nums2.toHashSet()
        set1.retainAll(set2)
        return set1.toIntArray()
    }
}
