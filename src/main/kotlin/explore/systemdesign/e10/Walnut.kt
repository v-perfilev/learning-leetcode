package explore.systemdesign.e10

class Walnut() {
    companion object {
        private const val SUM_REGEX = "(\\d*)(\\.\\d+)?"
        private val earningIds = arrayOf("credit", "credited", "deposit", "deposited")
        private val expenseIds = arrayOf("debit", "debited", "withdraw", "withdrawal", "withdrawn")
        private val amountIds = arrayOf("USD x", "x USD", "USDx", "$ x", "x $", "\\$" + "x")
    }

    private var earnings = mutableListOf<Double>()
    private var expenses = mutableListOf<Double>()
    private var userEarnings = mutableMapOf<Int, MutableList<Int>>()
    private var userExpenses = mutableMapOf<Int, MutableList<Int>>()
    private var userIds = mutableSetOf<Int>()

    fun parseText(userID: Int, text: String) {
        val sum = parseSum(text)
        if (sum != null && isEarning(text)) {
            userIds.add(userID)
            userEarnings.getOrPut(userID) { mutableListOf() }.add(earnings.size)
            earnings.add(sum)
        } else if (sum != null && isExpense(text)) {
            userIds.add(userID)
            userExpenses.getOrPut(userID) { mutableListOf() }.add(expenses.size)
            expenses.add(sum)
        }
    }

    fun getTotalUserEarnings(userID: Int): Double = userEarnings[userID]?.sumOf { earnings[it] } ?: 0.0

    fun getTotalUserExpenses(userID: Int): Double = userExpenses[userID]?.sumOf { expenses[it] } ?: 0.0

    fun getAverageUserEarnings(): Double = if (earnings.isNotEmpty()) earnings.sum() / userIds.size else 0.0

    fun getAverageUserExpenses(): Double = if (expenses.isNotEmpty()) expenses.sum() / userIds.size else 0.0

    private fun isEarning(text: String): Boolean = checkType(earningIds, text)

    private fun isExpense(text: String): Boolean = checkType(expenseIds, text)

    private fun checkType(ids: Array<String>, text: String): Boolean {
        for (id in ids) {
            if (text.startsWith(id)) return true
        }
        return false
    }

    private fun parseSum(text: String): Double? {
        for (amountId in amountIds) {
            val amountRegex = amountId.replace("x", SUM_REGEX).toRegex()
            val match = amountRegex.find(text)
            if (match != null) {
                var value = 0.0
                if (match.groupValues.isNotEmpty()) {
                    val intPart = if (match.groupValues[1].isNotBlank()) match.groupValues[1].toLong() else 0
                    if (intPart >= 1e9) return null
                    value += intPart.toDouble()
                }
                if (match.groupValues.size == 3) {
                    val floatPartString = match.groupValues[2]
                    if (floatPartString.length > 3) return null
                    value += ("0$floatPartString").toDouble()
                }
                return if (value > 0.0) value else null
            }
        }
        return null
    }
}
