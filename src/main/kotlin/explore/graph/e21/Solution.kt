package explore.graph.e21

class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        var costs = IntArray(n) { if (it == src) 0 else Int.MAX_VALUE / 2 }
        var stopsLeft = k
        var changed = true
        while (stopsLeft >= 0 && changed) {
            val tmpCosts = costs.clone()
            changed = false
            flights.forEach { (source, destination, price) ->
                if (tmpCosts[destination] > costs[source] + price) {
                    tmpCosts[destination] = costs[source] + price
                    changed = true
                }
            }
            costs = tmpCosts.clone()
            stopsLeft--
        }
        return if (costs[dst] == Int.MAX_VALUE / 2) -1 else costs[dst]
    }
}
