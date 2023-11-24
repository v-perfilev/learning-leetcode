package explore.datastructure.stacksqueues.e5

class StockSpanner() {
    private val stack = ArrayDeque<Pair<Int, Int>>()

    fun next(price: Int): Int {
        var res = 1
        while (stack.isNotEmpty() && stack.last().first <= price) {
            res += stack.removeLast().second
        }
        stack.add(price to res)
        return res
    }
}
