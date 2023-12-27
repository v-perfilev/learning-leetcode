package explore.systemdesign.e8

import java.util.Base64

class Codec() {
    companion object {
        const val BASE_URL = "https://tinyurl.com/"
    }

    private val encoder = Base64.getEncoder()
    private val urlMap = mutableMapOf<String, String>()

    fun encode(longUrl: String): String {
        var encoded: String
        var i = 0
        do {
            encoded = encodeWithBase64(longUrl + "_".repeat(i))
            i++
        } while (urlMap.contains(encoded) && urlMap[encoded] != longUrl)
        if (!urlMap.contains(encoded)) urlMap[encoded] = longUrl
        return BASE_URL + encoded
    }

    fun decode(shortUrl: String): String {
        if (!shortUrl.startsWith(BASE_URL)) return ""
        val encoded = shortUrl.substring(BASE_URL.length)
        return urlMap[encoded] ?: ""
    }

    private fun encodeWithBase64(longUrl: String): String {
        val encodedFullStr = encoder.encodeToString(longUrl.toByteArray())
        return encodedFullStr.substring(encodedFullStr.length - 5)
    }
}
