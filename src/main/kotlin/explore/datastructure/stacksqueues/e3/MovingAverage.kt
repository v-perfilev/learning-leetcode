package explore.datastructure.stacksqueues.e3

class MovingAverage(size: Int) {
    private var queue = ArrayDeque<Int>()
    private val limit = size

    fun next(`val`: Int): Double {
        queue.add(`val`)
        if (queue.size > limit) queue.removeFirst()
        return queue.sum().toDouble() / queue.size
    }
}
