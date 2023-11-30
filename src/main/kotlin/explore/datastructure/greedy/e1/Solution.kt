package explore.datastructure.greedy.e1

class Solution {
    fun maximum69Number (num: Int): Int {
        val arr = num.toString().toCharArray()
        for (i in arr.indices) {
            if (arr[i] == '6') {
                arr[i] = '9'
                break
            }
        }
        return arr.concatToString().toInt()
    }
}
