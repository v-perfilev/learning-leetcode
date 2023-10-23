package explore.dp.e8

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
        return TopDownDifficultyFinder().findMin(jobDifficulty, d)
    }

    companion object {
        interface DifficultyFinder {
            fun findMin(jobDifficulty: IntArray, d: Int): Int
        }

        class TopDownDifficultyFinder : DifficultyFinder {
            private lateinit var cache: Array<IntArray>
            private lateinit var jobDifficulty: IntArray
            private lateinit var hardestJobRemaining: IntArray
            private var jobCount = 0
            private var dayCount = 0

            override fun findMin(jobDifficulty: IntArray, d: Int): Int {
                this.jobDifficulty = jobDifficulty
                this.jobCount = jobDifficulty.size
                this.dayCount = d

                if (this.jobCount < this.dayCount) return -1

                this.hardestJobRemaining = IntArray(this.jobCount)
                var hardestJob = 0
                for (i in jobCount - 1 downTo 0) {
                    hardestJob = max(hardestJob, this.jobDifficulty[i])
                    this.hardestJobRemaining[i] = hardestJob
                }

                this.cache = Array(this.jobCount) { IntArray(this.dayCount) { -1 } }

                return dp(0, 0)
            }

            private fun dp(job: Int, day: Int): Int {
                if (day == dayCount - 1) return this.hardestJobRemaining[job]

                if (this.cache[job][day] == -1) {
                    var best = Int.MAX_VALUE
                    var hardest = 0
                    for (i in job..this.jobCount - this.dayCount + day) {
                        hardest = max(hardest, this.jobDifficulty[i])
                        best = min(best, hardest + dp(i + 1, day + 1))
                    }
                    this.cache[job][day] = best
                }

                return this.cache[job][day]
            }
        }
    }
}
