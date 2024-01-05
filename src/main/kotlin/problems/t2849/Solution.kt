package problems.t2849

import kotlin.math.abs

class Solution {

    fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean {
        val minSteps = maxOf(abs(sx - fx), abs(sy - fy))
        return (minSteps != 0 || t != 1) && t > minSteps
    }

}
