package problems.t502

import java.util.PriorityQueue

class Solution {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        var cap = w
        val pq = PriorityQueue<Int>(Comparator.reverseOrder())
        val arr = Array(profits.size) { profits[it] to capital[it] }.sortedBy { it.second }
        var arrPointer = 0
        while (arrPointer < arr.size && arr[arrPointer].second <= cap) pq.add(arr[arrPointer++].first)
        var counter = 0
        while (counter < k && pq.isNotEmpty()) {
            cap += pq.poll()
            counter++
            while (arrPointer < arr.size && arr[arrPointer].second <= cap) pq.add(arr[arrPointer++].first)
        }
        return cap
    }
}
