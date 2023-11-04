package problems.t68

class Solution {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val result = mutableListOf<String>()

        var i = 0
        while (i < words.size) {

            var counter = 0
            var wordsLength = 0
            while (i < words.size && wordsLength + words[i].length + counter <= maxWidth) {
                wordsLength += words[i].length
                counter++
                i++
            }
            if (counter == 1) {
                val sb = justifyOneWord(words, i - 1, maxWidth)
                result.add(sb.toString())
            } else if (i == words.size) {
                val sb = justifyLastString(words, i - 1, counter, wordsLength, maxWidth)
                result.add(sb.toString())
            } else if (counter > 1) {
                val sb = justifyMultipleWords(words, i - 1, counter, wordsLength, maxWidth)
                result.add(sb.toString())
            }
        }

        return result
    }

    private fun justifyOneWord(words: Array<String>, i: Int, maxWidth: Int): StringBuilder {
        val sb = StringBuilder()
        sb.append(words[i])
        appendSpaces(sb, maxWidth - words[i].length)
        return sb
    }

    private fun justifyMultipleWords(
        words: Array<String>,
        i: Int,
        counter: Int,
        wordsLength: Int,
        maxWidth: Int
    ): StringBuilder {
        val sb = StringBuilder()
        val spaceCount = maxWidth - wordsLength
        val minSpaceCount: Int = spaceCount / (counter - 1)
        val wordsWithAdditionalSpaceCount = spaceCount - minSpaceCount * (counter - 1)
        var j = i - counter + 1
        while (j < i) {
            sb.append(words[j])
            appendSpaces(sb, minSpaceCount + if (j - (i - counter + 1) < wordsWithAdditionalSpaceCount) 1 else 0)
            j++
        }
        sb.append(words[j])
        return sb
    }

    private fun justifyLastString(
        words: Array<String>,
        i: Int,
        counter: Int,
        wordsLength: Int,
        maxWidth: Int
    ): StringBuilder {
        val sb = StringBuilder()
        val spaceCount = maxWidth - wordsLength
        var j = i - counter + 1
        while (j < i) {
            sb.append(words[j])
            appendSpaces(sb, 1)
            j++
        }
        sb.append(words[j])
        appendSpaces(sb, spaceCount - counter + 1)
        return sb
    }

    private fun appendSpaces(sb: StringBuilder, count: Int) {
        for (i in 0..<count) sb.append(' ')
    }
}
