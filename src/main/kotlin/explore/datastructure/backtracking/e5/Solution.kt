package explore.datastructure.backtracking.e5

class Solution {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        backtracking(k, n, res, mutableListOf(), 0, 0)
        return res
    }

    private fun backtracking(k: Int, n: Int, res: MutableList<List<Int>>, list: MutableList<Int>, sum: Int, cur: Int) {
        if (k == 0 && sum == n) {
            res.add(ArrayList(list))
            return
        }
        for (i in cur + 1..9) {
            if (sum + i <= n) {
                list.add(i)
                backtracking(k - 1, n, res, list, sum + i, i)
                list.removeLast()
            }
        }
    }
}
