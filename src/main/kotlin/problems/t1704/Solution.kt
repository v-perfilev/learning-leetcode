package problems.t1704

class Solution {
    fun halvesAreAlike(s: String): Boolean {
        var counter = 0
        for (i in s.indices) {
            if (vowels.contains(s[i])) {
                if (i < s.length / 2) counter++ else counter--
            }
            if (counter < 0) return false
        }
        return counter == 0
    }

    companion object {
        private val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    }
}
