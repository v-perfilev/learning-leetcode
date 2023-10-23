package explore.binarysearch.e17

class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        nums1.sort()
        nums2.sort()
        var a = 0
        var b = 0
        var k = 0
        while (a < nums1.size && b < nums2.size) {
            if (nums1[a] < nums2[b]) {
                a++
            } else if (nums1[a] > nums2[b]) {
                b++
            }  else {
                nums1[k] = nums1[a]
                k++
                a++
                b++
            }
        }
        return nums1.copyOfRange(0, k)
    }
}
