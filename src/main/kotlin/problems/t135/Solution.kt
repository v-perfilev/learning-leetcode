package problems.t135

class Solution {

    fun candy(ratings: IntArray): Int {
        val candies = IntArray(ratings.size)
        candies.forEachIndexed { index, _ -> candies[index] = 1 }

        var changed = true
        while (changed) {
            changed = false
            for (i in ratings.indices) {
                if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1
                    changed = true
                }
                if (i < ratings.size - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1
                    changed = true
                }
            }
        }

        return candies.sum()
    }

}
