package explore.datastructure.treesgraphs.e12

class Solution {
    fun snakesAndLadders(board: Array<IntArray>): Int {
        val n = board.size
        val destination = n * n
        val maxSteps = minOf(6, n * n)
        var counter = 0
        val queue = ArrayDeque<Int>().apply { add(1) }
        val visited = BooleanArray(destination + 1) { it == 1 }
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val i = queue.removeFirst()
                if (i == destination) return counter
                for (j in 1..maxSteps) {
                    if (i + j > destination) continue
                    val (y, x) = getYX(n, i + j)
                    val next = if (board[y][x] != -1) board[y][x] else i + j
                    if (!visited[next]) {
                        queue.add(next)
                        visited[next] = true
                    }
                }
            }
            counter++
        }
        return -1
    }

    private fun getYX(n: Int, i: Int): IntArray {
        val y = n - 1 - (i - 1) / n
        val x = if ((n - y - 1) % 2 == 0) (i - 1) % n else n - (i - 1) % n - 1
        return intArrayOf(y, x)
    }
}

