package problems.t387

class Solution {

    fun firstUniqChar(s: String): Int {
        val map = linkedMapOf<Char, Int>()
        s.forEachIndexed { index, char ->
            if (map.contains(char)) map[char] = -1
            else map[char] = index
        }
        return map.values.firstOrNull { it != -1 } ?: -1
    }
}
