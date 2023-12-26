package explore.systemdesign.e4

import java.util.LinkedList

class WhatsApp {
    private val messages = mutableListOf<String>()
    private val userMessagesMap = mutableMapOf<Int, LinkedList<Int>>()
    private val groups = mutableListOf<MutableSet<Int>>()

    fun sendMessage(toUser: Int, message: String) {
        val messageId = messages.size
        messages.add(message)
        userMessagesMap.putIfAbsent(toUser, LinkedList())
        userMessagesMap[toUser]!!.addFirst(messageId)
    }

    fun createGroup(initialUsers: IntArray): Int {
        val group = initialUsers.toMutableSet()
        groups.add(group)
        return groups.size
    }

    fun addUserToGroup(groupId: Int, userId: Int) {
        if (groupId - 1 >= groups.size) return
        groups[groupId - 1].add(userId)
    }

    fun sendGroupMessage(fromUser: Int, groupId: Int, message: String) {
        if (groupId - 1 >= groups.size) return
        if (!groups[groupId - 1].contains(fromUser)) return
        val messageId = messages.size
        messages.add(message)
        groups[groupId - 1].filter { it != fromUser }.forEach {
            userMessagesMap.putIfAbsent(it, LinkedList())
            userMessagesMap[it]!!.addFirst(messageId)
        }
    }

    fun getMessagesForUser(userId: Int): List<String> {
        return userMessagesMap[userId]?.map { messages[it] } ?: listOf()
    }
}
