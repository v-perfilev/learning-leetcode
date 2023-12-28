package explore.systemdesign.e11

class TodoList() {
    private val tasks = mutableListOf<Task>().apply { add(Task("", 0)) }
    private val tagMap = mutableMapOf<String, MutableList<Int>>()
    private val userMap = mutableMapOf<Int, MutableSet<Int>>()

    fun addTask(userId: Int, taskDescription: String, dueDate: Int, tags: List<String>): Int {
        val taskId = tasks.size
        val task = Task(taskDescription, dueDate)
        tasks.add(task)
        userMap.getOrPut(userId) { mutableSetOf() }.add(taskId)
        tags.forEach { tagMap.getOrPut(it) { mutableListOf() }.add(taskId) }
        return taskId
    }

    fun getAllTasks(userId: Int): List<String> =
        userMap[userId]?.getAll() ?: listOf()

    fun getTasksForTag(userId: Int, tag: String): List<String> =
        tagMap[tag]?.intersect(userMap[userId] ?: setOf())?.getAll() ?: listOf()

    fun completeTask(userId: Int, taskId: Int) {
        if (tasks.size > taskId && userMap[userId]?.contains(taskId) == true) {
            tasks[taskId].completed = true
        }
    }

    private fun Collection<Int>.getAll(): List<String> =
        this
            .map { tasks[it] }
            .filter { !it.completed }
            .sortedBy { it.dueDate }
            .map { it.taskDescription }

    private data class Task(val taskDescription: String, val dueDate: Int, var completed: Boolean = false)
}
