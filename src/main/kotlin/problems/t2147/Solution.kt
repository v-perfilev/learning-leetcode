package problems.t2147

class Solution {
    fun numberOfWays(corridor: String): Int {
        val combinationCountList = mutableListOf<Long>()
        var seatCounter = 0
        var i = 0
        while (i < corridor.length) {
            if (corridor[i] == SEAT) seatCounter++
            if (seatCounter > 0 && seatCounter % 2 == 0) {
                var j = 1
                while (i + j < corridor.length && corridor[i + j] == PLANT) j++
                if (i + j != corridor.length) combinationCountList.add(j.toLong())
                i += j
            } else {
                i++
            }
        }
        return if (seatCounter == 0 || seatCounter % 2 == 1) 0
        else (if (seatCounter == 2) 1
        else combinationCountList.reduce { acc, value -> acc * value % MOD } % MOD).toInt()
    }

    companion object {
        private const val MOD = (1e9 + 7).toInt()
        private const val SEAT = 'S'
        private const val PLANT = 'P'
    }
}
