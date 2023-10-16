package explore.graph.e11

import java.util.PriorityQueue

class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val ticketMap = buildTicketMap(tickets)
        return dfs(ticketMap, ArrayDeque(), "JFK")
    }

    private fun buildTicketMap(tickets: List<List<String>>): Map<String, PriorityQueue<String>> {
        val map = mutableMapOf<String, PriorityQueue<String>>()
        tickets.forEach { (departure, destination) ->
            map.getOrPut(departure) { PriorityQueue() }.add(destination)
            map.getOrPut(destination) { PriorityQueue() }
        }
        return map
    }

    private fun dfs(
        ticketMap: Map<String, PriorityQueue<String>>,
        itinerary: ArrayDeque<String>,
        departure: String
    ): ArrayDeque<String> {
        while (ticketMap[departure]!!.isNotEmpty()) {
            val destination = ticketMap[departure]!!.poll()
            dfs(ticketMap, itinerary, destination)
        }
        return itinerary.also { it.addFirst(departure) }
    }
}
