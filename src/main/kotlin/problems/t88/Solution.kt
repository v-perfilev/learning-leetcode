package problems.t88

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var nums1Index = m - 1
        var nums2Index = n - 1
        var totalIndex = m + n - 1

        while (totalIndex >= 0) {
            nums1[totalIndex--] =
                if (nums1Index >= 0 && (nums2Index < 0 || nums1[nums1Index] > nums2[nums2Index])) nums1[nums1Index--]
                else nums2[nums2Index--]
        }
    }
}
