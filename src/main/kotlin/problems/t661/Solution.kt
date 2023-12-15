package problems.t661

import kotlin.math.floor

class Solution {
    fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
        val m = img.size
        val n = img.first().size
        val res = Array(m) { IntArray(n) }
        for (i in 0..<m) {
            for (j in 0..<n) {
                val avg = cells.filter { (dy, dx) -> i + dy in 0..<m && j + dx in 0..<n }
                    .map { (dy, dx) -> img[i + dy][j + dx] }
                    .average()
                res[i][j] = floor(avg).toInt()
            }
        }
        return res
    }

    companion object {
        val cells = arrayOf(
            intArrayOf(-1, -1),
            intArrayOf(-1, 0),
            intArrayOf(-1, 1),
            intArrayOf(0, -1),
            intArrayOf(0, 0),
            intArrayOf(0, 1),
            intArrayOf(1, -1),
            intArrayOf(1, 0),
            intArrayOf(1, 1),
        )
    }
}
