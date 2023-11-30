package explore.datastructure.greedy.e3

class Solution {
    fun maxNumberOfApples(weight: IntArray): Int {
        val sortedWeights = weight.sortedArray()
        var sum = 0
        var pointer = 0
        while (pointer < sortedWeights.size) {
            sum += sortedWeights[pointer]
            if (sum > 5000) return pointer
            pointer++
        }
        return pointer
    }
}
