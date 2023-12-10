package problems.t274

class Solution {
    fun hIndex(citations: IntArray): Int {
        var h = 0
        citations.sort()
        citations.forEachIndexed { index, citation ->
            val count = citations.size - index
            if (citation in (h + 1)..count) h = citation
            else if (count in (h + 1)..<citation) h = count
        }
        return h
    }
}
