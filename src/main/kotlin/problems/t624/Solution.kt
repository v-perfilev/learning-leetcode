package problems.t624

import java.util.PriorityQueue
import kotlin.math.abs

class Solution {
    fun maxDistance(arrays: List<List<Int>>): Int {
        val minPq = PriorityQueue<Pair<Int, Int>> { o1, o2 -> if (o1.first > o2.first) 1 else -1 }
        val maxPq = PriorityQueue<Pair<Int, Int>> { o1, o2 -> if (o1.first < o2.first) 1 else -1 }
        arrays.forEachIndexed { index, arr ->
            minPq.offer(arr.first() to index)
            maxPq.offer(arr.last() to index)
        }
        return if (minPq.peek().second != maxPq.peek().second) {
            abs(maxPq.poll().first - minPq.poll().first)
        } else {
            val max1 = maxPq.poll().first
            val max2 = maxPq.poll().first
            val min1 = minPq.poll().first
            val min2 = minPq.poll().first
            maxOf(
                abs(max2 - min1),
                abs(max1 - min2),
            )
        }
    }
}
