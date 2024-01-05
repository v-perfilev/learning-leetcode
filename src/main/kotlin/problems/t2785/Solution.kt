package problems.t2785

class Solution {
    companion object {
        val vowels = hashSetOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    }

    fun sortVowels(s: String): String {
        val vowelList = ArrayList<Char>()
        val vowelIndices = ArrayList<Int>()
        s.forEachIndexed { index, c ->
            if (isVowel(c)) {
                vowelList.add(c)
                vowelIndices.add(index)
            }
        }
        vowelList.sort()
        val sb = StringBuilder(s)
        vowelIndices.forEachIndexed { index, vowelIndex ->
            sb[vowelIndex] = vowelList[index]
        }
        return sb.toString()
    }

    private fun isVowel(c: Char): Boolean = vowels.contains(c)
}
