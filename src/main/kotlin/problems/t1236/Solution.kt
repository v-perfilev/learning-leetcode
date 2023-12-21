package problems.t1236

class Solution {
    private lateinit var htmlParser: HtmlParser
    private lateinit var hostname: String
    private lateinit var resSet: MutableSet<String>

    fun crawl(startUrl: String, htmlParser: HtmlParser): List<String> {
        this.htmlParser = htmlParser
        this.hostname = getHostname(startUrl)
        this.resSet = mutableSetOf()
        dfs(startUrl)
        return resSet.sorted()
    }

    private fun dfs(url: String) {
        resSet.add(url)
        val urlList = htmlParser.getUrls(url)
        urlList
            .filter { getHostname(it) == hostname }
            .forEach { if (!resSet.contains(it)) dfs(it) }
    }

    private fun getHostname(url: String): String {
        val regex = "https?://([\\d\\w\\.\\-]+)/?.*".toRegex()
        return regex.matchEntire(url)!!.groupValues[1]
    }

    companion object {
        interface HtmlParser {
            fun getUrls(url: String): List<String>
        }
    }
}
