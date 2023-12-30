package explore.bit.e1

class Solution {
    fun convertToBase7(num: Int): String {
        if (num == 0) return "0"
        val isNegative = num < 0
        val l = mutableListOf<Int>()
        var rest = if (isNegative) -num else num
        while (rest > 0) {
            l.add((rest % 7))
            rest /= 7
        }
        var resString = l.reversed().joinToString("")
        if (isNegative) resString = "-$resString"
        return resString
    }
}
