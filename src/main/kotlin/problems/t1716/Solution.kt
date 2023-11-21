package problems.t1716

class Solution {
    fun totalMoney(n: Int): Int =
        (0..<n).sumOf { 1 + it % 7 + it / 7 }
}
