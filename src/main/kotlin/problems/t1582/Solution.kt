package problems.t1582

class Solution {
    fun numSpecial(mat: Array<IntArray>): Int {
        val specRowCount = Array(mat.size) { mat[it].sum() }
        val specColCount = Array(mat.first().size) { mat.map { m -> m[it] }.sum() }
        var count = 0
        for (j in mat.indices) {
            for (i in mat.first().indices) {
                if (mat[j][i] == 1 && specRowCount[j] == 1 && specColCount[i] == 1) count++
            }
        }
        return count
    }
}
