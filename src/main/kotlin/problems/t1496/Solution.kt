package problems.t1496

class Solution {
    fun isPathCrossing(path: String): Boolean {
        val current = intArrayOf(0, 0)
        val visited = mutableSetOf(current.toStr())
        for (c in path) {
            when (c) {
                'N' -> current[0]++
                'E' -> current[1]++
                'S' -> current[0]--
                'W' -> current[1]--
            }
            val str = current.toStr()
            if (visited.contains(str)) return true
            visited.add(str)
        }
        return false
    }

    private fun IntArray.toStr(): String = "${this[0]}_${this[1]}"
}
