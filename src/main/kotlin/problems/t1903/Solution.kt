package problems.t1903

class Solution {
    fun largestOddNumber(num: String): String {
        if (num.isEmpty()) return ""
        var pointer = num.length - 1
        while (pointer >= 0 && num[pointer].code % 2 == 0) pointer--
        return num.substring(0, pointer + 1)
    }
}
