package explore.datastructure.bonus.e2

class Solution {
    fun hammingDistance(x: Int, y: Int): Int =
        (0..31).map { if (x shr it and 1 != y shr it and 1) 1 else 0 }.sum()
}
