package explore.bit.e2

class Solution {
    fun toHex(num: Int): String {
        if (num == 0) return "0"

        val hexChars = "0123456789abcdef"
        var number = num
        val result = StringBuilder()

        for (i in 0..<8) {
            val hexValue = number and 15
            result.insert(0, hexChars[hexValue])
            number = number ushr 4
        }

        while (result.isNotEmpty() && result[0] == '0') {
            result.deleteCharAt(0)
        }

        return result.toString()
    }

}
