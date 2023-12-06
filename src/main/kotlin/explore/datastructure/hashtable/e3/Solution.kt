package explore.datastructure.hashtable.e3

class Solution {
    fun countElements(arr: IntArray): Int {
        val elementSet = arr.toSet()
        var counter = 0
        arr.forEach { if (elementSet.contains(it + 1)) counter++ }
        return counter
    }
}
