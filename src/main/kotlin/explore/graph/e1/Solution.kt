package explore.graph.e1

class Solution {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val arr = IntArray(isConnected.size) { it }
        val size = isConnected.size
        for (i in 0..<size) {
            for (j in 0..<size) {
                if (i != j && isConnected[i][j] == 1) {
                    val min = minOf(arr[i], arr[j])
                    val max = maxOf(arr[i], arr[j])
                    for (x in isConnected.indices) {
                        if (arr[x] == max) {
                            arr[x] = min
                        }
                    }
                }
            }
        }
        println(arr.contentToString())
        var counter = 0
        for (i in arr.indices) {
            if (arr[i] != i) counter++
        }
        return counter
    }
}
