package problems.t232

class MyQueue() {
    private val stack = ArrayDeque<Int>()

    fun push(x: Int) {
        val tmpStack = ArrayDeque<Int>()
        while (stack.isNotEmpty()) tmpStack.addLast(stack.removeLast())
        stack.addLast(x)
        while (tmpStack.isNotEmpty()) stack.addLast(tmpStack.removeLast())
    }

    fun pop(): Int {
        return stack.removeLast()
    }

    fun peek(): Int {
        return stack.last()
    }

    fun empty(): Boolean {
        return stack.isEmpty()
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
