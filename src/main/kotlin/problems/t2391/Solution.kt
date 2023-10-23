package problems.t2391

class Solution {
    private lateinit var travelTimePrefixSum: IntArray
    private val counts = IntArray(3)
    private val lastHouseIds = IntArray(3)

    fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
        countGarbageAndRecordLastHouse(garbage)
        computeTravelTimePrefixSum(travel)
        return calcTotalTime()
    }

    private fun calcTotalTime(): Int {
        var time = 0
        for (i in 0..<3) {
            time += travelTimePrefixSum[lastHouseIds[i]] + counts[i]
        }
        return time
    }

    private fun countGarbageAndRecordLastHouse(garbage: Array<String>) {
        for (i in garbage.indices) {
            countGarbageTypeAndUpdateLastHouse(garbage, 'M', 0, i)
            countGarbageTypeAndUpdateLastHouse(garbage, 'P', 1, i)
            countGarbageTypeAndUpdateLastHouse(garbage, 'G', 2, i)
        }
    }

    private fun countGarbageTypeAndUpdateLastHouse(garbage: Array<String>, letter: Char, number: Int, step: Int) {
        val mCount = garbage[step].count { it == letter }
        counts[number] += mCount
        if (mCount > 0) lastHouseIds[number] = step
    }

    private fun computeTravelTimePrefixSum(travel: IntArray) {
        travelTimePrefixSum = IntArray(travel.size + 1)
        for (i in travel.indices) {
            travelTimePrefixSum[i + 1] = travelTimePrefixSum[i] + travel[i]
        }
    }
}
