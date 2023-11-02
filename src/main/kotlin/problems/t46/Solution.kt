package problems.t46

class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        permute(nums, res, mutableListOf())
        return res
    }

    private fun permute(nums: IntArray, res: MutableList<List<Int>>, cur: MutableList<Int>) {
        if (cur.size == nums.size) {
            res.add(ArrayList(cur))
        }
        nums.forEach {
            if (!cur.contains(it)) {
                cur.add(it)
                permute(nums, res, cur)
                cur.removeLast()
            }
        }
    }
}
