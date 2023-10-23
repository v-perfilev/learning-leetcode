package explore.binarysearch.e20

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if (nums1.size > nums2.size) {
            return findMedianSortedArrays(nums2, nums1)
        }

        var l = 0
        var r = nums1.size
        while (l <= r) {
            val pivot1 = (l + r) / 2
            val pivot2 = (nums1.size + nums2.size + 1) / 2 - pivot1

            val maxLeft1 = if (pivot1 == 0) Int.MIN_VALUE else nums1[pivot1 - 1]
            val minRight1 = if (pivot1 == nums1.size) Int.MAX_VALUE else nums1[pivot1]
            val maxLeft2 = if (pivot2 == 0) Int.MIN_VALUE else nums2[pivot2 - 1]
            val minRight2 = if (pivot2 == nums2.size) Int.MAX_VALUE else nums2[pivot2]

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                return if ((nums1.size + nums2.size) % 2 == 0) {
                    (max(maxLeft1, maxLeft2) + min(minRight1, minRight2)) / 2.0
                } else {
                    max(maxLeft1, maxLeft2).toDouble()
                }
            } else if (maxLeft1 > minRight2) {
                r = pivot1 - 1
            } else {
                l = pivot1 + 1
            }
        }

        return 0.0
    }
}
