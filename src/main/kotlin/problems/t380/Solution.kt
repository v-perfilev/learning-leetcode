package problems.t380

import kotlin.random.Random

class RandomizedSet() {
    companion object {
        private const val DEFAULT_SIZE = 10
    }

    private var container = intArrayOf(DEFAULT_SIZE)
    private var size = 0

    fun insert(item: Int): Boolean {
        if (checkIfExists(item)) return false
        increaseSizeIfNeeded()
        container[size] = item
        size++
        return true
    }

    fun remove(item: Int): Boolean {
        if (!checkIfExists(item)) return false
        if (size > 1) {
            val index = container.indexOf(item)
            container[index] = container[size - 1]
        }
        size--
        decreaseSizeIfNeeded()
        return true
    }

    fun getRandom(): Int {
        val index = if (size > 1) Random.nextInt(size) else 0
        return container[index]
    }

    private fun checkIfExists(item: Int): Boolean {
        for (i in 0..<size) {
            if (container[i] == item) return true
        }
        return false
    }

    private fun increaseSizeIfNeeded() {
        if (size == container.size) {
            val newContainer = IntArray(container.size * 2)
            container.forEachIndexed { index, it -> newContainer[index] = it }
            container = newContainer
        }
    }

    private fun decreaseSizeIfNeeded() {
        if (container.size / 2 < size && container.size > DEFAULT_SIZE && container.size.mod(DEFAULT_SIZE) == 0) {
            val newContainer = IntArray(container.size / 2)
            for (i in newContainer.indices) {
                newContainer[i] = container[i]
            }
            container = newContainer
        }
    }
}
