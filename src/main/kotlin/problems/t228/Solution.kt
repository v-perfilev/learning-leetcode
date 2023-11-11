package problems.t228

class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        val resultList = mutableListOf<String>()

        if (nums.size == 1) {
            resultList.add("${nums[0]}")
        } else {
            var a = 0
            for (i in 1..<nums.size) {
                if (nums[i] != nums[i - 1] + 1) {
                    if (i - 1 == a) {
                        resultList.add("${nums[a]}")
                    } else {
                        resultList.add("${nums[a]}->${nums[i - 1]}")
                    }
                    a = i
                }
                if (i == nums.size - 1) {
                    if (i == a) {
                        resultList.add("${nums[a]}")
                    } else {
                        resultList.add("${nums[a]}->${nums[i]}")
                    }
                    a = i
                }
            }
        }

        return resultList
    }
}
