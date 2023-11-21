package problems.t2125

class Solution {
    fun numberOfBeams(bank: Array<String>): Int {
        var res = 0
        var previousDeviceCount = 0
        bank.forEach { row ->
            val currentDeviceCount = row.count { it == '1' }
            if (currentDeviceCount > 0) {
                res += previousDeviceCount * currentDeviceCount
                previousDeviceCount = currentDeviceCount
            }
        }
        return res
    }
}
