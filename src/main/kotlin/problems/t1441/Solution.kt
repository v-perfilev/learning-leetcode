package problems.t1441

class Solution {
    fun buildArray(target: IntArray, n: Int): List<String> {
        val resultList = mutableListOf<String>()
        var number = 1
        var counter = 0
        while (counter < target.size) {
            while (number != target[counter]) {
                resultList.add("Push")
                resultList.add("Pop")
                number++
            }
            resultList.add("Push")
            counter++
            number++
        }
        return resultList
    }
}
