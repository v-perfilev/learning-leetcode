package explore.systemdesign.e5

import java.util.LinkedList

class Facebook() {
    val posts = mutableListOf<String>()
    val userPostsMap = mutableMapOf<Int, LinkedList<Int>>()
    val friendMap = mutableMapOf<Int, MutableSet<Int>>()

    fun writePost(userId: Int, postContent: String) {
        val postId = posts.size
        posts.add(postContent)
        userPostsMap.getOrPut(userId) { LinkedList() }.addFirst(postId)
    }

    fun addFriend(user1: Int, user2: Int) {
        friendMap.getOrPut(user1) { HashSet() }.add(user2)
        friendMap.getOrPut(user2) { HashSet() }.add(user1)
    }

    fun showPosts(userId: Int): List<String> {
        return friendMap.getOrDefault(userId, listOf())
            .flatMap { userPostsMap.getOrDefault(it, listOf()) }
            .distinct()
            .sortedWith(Comparator.reverseOrder())
            .map { posts[it] }
    }
}
