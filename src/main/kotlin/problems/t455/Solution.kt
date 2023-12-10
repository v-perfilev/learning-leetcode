package problems.t455

class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        val kids = g.sorted()
        val cookies = s.sorted()
        var k = 0
        var c = 0
        while (k < kids.size && c < cookies.size) {
            if (kids[k] <= cookies[c]) k++
            c++
        }
        return k
    }
}
