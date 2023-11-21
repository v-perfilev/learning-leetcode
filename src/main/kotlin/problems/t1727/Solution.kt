package problems.t1727

class Solution {
    fun largestSubmatrix(matrix: Array<IntArray>): Int {
        val vLength = matrix.size
        val hLength = matrix.first().size
        val arr = Array(vLength) { IntArray(hLength) }
        for (x in 0..<hLength) {
            var counter = 0
            for (y in 0..<vLength) {
                if (matrix[y][x] == 1) counter++
                else counter = 0
                arr[y][x] = counter
            }
        }
        var max = 0
        for (y in 0..<vLength) {
            val map = mutableMapOf<Int, Int>()
            for (x in 0..<hLength) {
                val grad = arr[y][x]
                for (i in 0..grad) {
                    map[i] = map.getOrPut(i) { 0 } + 1
                }
            }
            map.forEach { (key, value) -> max = maxOf(max, key * value) }
        }
        return max
    }
}
