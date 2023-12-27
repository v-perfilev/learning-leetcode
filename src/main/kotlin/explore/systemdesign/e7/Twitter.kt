package explore.systemdesign.e7

class Twitter() {
    private val tweets = mutableListOf<Int>()
    private val userTweetMap = mutableMapOf<Int, MutableList<Int>>()
    private val userFollowMap = mutableMapOf<Int, MutableSet<Int>>()

    fun postTweet(userId: Int, tweetId: Int) {
        val id = tweets.size
        tweets.add(tweetId)
        userTweetMap.getOrPut(userId) { ArrayList() }.add(id)
    }

    fun getNewsFeed(userId: Int): List<Int> {
        return ArrayList(userFollowMap[userId] ?: listOf())
            .apply { add(userId) }
            .flatMap { userTweetMap.getOrDefault(it, ArrayList()) }
            .distinct()
            .sortedDescending()
            .take(10)
            .map { tweets[it] }
    }

    fun follow(followerId: Int, followeeId: Int) {
        userFollowMap.getOrPut(followerId) { HashSet() }.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        userFollowMap[followerId]?.remove(followeeId)
    }
}
