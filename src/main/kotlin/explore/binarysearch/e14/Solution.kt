package explore.binarysearch.e14

class Solution {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var l = 0
        var r = letters.size

        while (l < r) {
            val mid = l + (r - l) / 2
            if (letters[mid] > target && (mid == 0 || letters[mid - 1] <= target)) return letters[mid]
            if (letters[mid] <= target) l = mid + 1
            else r = mid
        }

        if (l < letters.size && letters[l] > target) return letters[l]
        return letters[0]
    }
}
