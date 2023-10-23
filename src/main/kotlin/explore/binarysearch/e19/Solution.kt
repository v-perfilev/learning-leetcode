package explore.binarysearch.e19

class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var n1 = 0
        var n2 = 0
        do {
            n1 = nums[n1]
            n2 = nums[nums[n2]]
        } while (n1 != n2)

        n2 = 0
        while (n1 != n2) {
            n1 = nums[n1]
            n2 = nums[n2]
        }

        return n1
    }
}
