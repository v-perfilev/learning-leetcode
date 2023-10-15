package explore.graph.e6

class Solution {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {

        val gidWeight = HashMap<String, Pair<String, Double>>()

        // Step 1). build the union groups
        equations.forEachIndexed() { index, equation ->
            val dividend = equation[0]
            val divisor = equation[1]
            val quotient = values[index]
            union(gidWeight, dividend, divisor, quotient)
        }

        // Step 2). run the evaluation, with "lazy" updates in find() function
        val results = DoubleArray(queries.size)
        for (i in queries.indices) {
            val query = queries[i]
            val dividend = query[0]
            val divisor = query[1]
            if (!gidWeight.containsKey(dividend) || !gidWeight.containsKey(divisor)) // case 1). at least one variable did not appear before
                results[i] = -1.0 else {
                val dividendEntry = find(gidWeight, dividend)
                val divisorEntry = find(gidWeight, divisor)
                val dividendGid = dividendEntry.first
                val divisorGid = divisorEntry.first
                val dividendWeight = dividendEntry.second
                val divisorWeight = divisorEntry.second
                if (dividendGid != divisorGid) // case 2). the variables do not belong to the same chain/group
                    results[i] = -1.0 else  // case 3). there is a chain/path between the variables
                    results[i] = dividendWeight / divisorWeight
            }
        }

        return results
    }

    private fun find(gidWeight: MutableMap<String, Pair<String, Double>>, nodeId: String): Pair<String, Double> {
        val entry = gidWeight.getOrPut(nodeId) { Pair(nodeId, 1.0) }
        // found inconsistency, trigger chain update
        if (entry.first != nodeId) {
            val newEntry = find(gidWeight, entry.first)
            gidWeight[nodeId] = Pair(newEntry.first, entry.second * newEntry.second)
        }
        return gidWeight[nodeId]!!
    }

    private fun union(
        gidWeight: HashMap<String, Pair<String, Double>>,
        dividend: String,
        divisor: String,
        value: Double
    ) {
        val dividendEntry = find(gidWeight, dividend)
        val divisorEntry = find(gidWeight, divisor)
        val dividendGid = dividendEntry.first
        val divisorGid = divisorEntry.first
        val dividendWeight = dividendEntry.second
        val divisorWeight = divisorEntry.second

        // merge the two groups together,
        // by attaching the dividend group to the one of divisor
        if (dividendGid != divisorGid) {
            gidWeight[dividendGid] = Pair(divisorGid, divisorWeight * value / dividendWeight)
        }
    }
}
