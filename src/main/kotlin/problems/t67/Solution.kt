package problems.t67

class Solution {
    fun addBinary(a: String, b: String): String {
        return (a.toInt(2) + b.toInt(2)).toString(2)
    }
}
