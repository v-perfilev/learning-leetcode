package explore.systemdesign.e1

class LogAggregator(machines: Int, services: Int) {
    private val machineMap = Array<MutableList<LogEntry>>(machines) { mutableListOf() }
    private val serviceMap = Array<MutableList<LogEntry>>(services) { mutableListOf() }

    fun pushLog(logId: Int, machineId: Int, serviceId: Int, message: String) {
        val logEntry = LogEntry(logId, message)
        serviceMap[serviceId].add(logEntry)
        machineMap[machineId].add(logEntry)
    }

    fun getLogsFromMachine(machineId: Int): List<Int> =
        machineMap[machineId].map { it.id }

    fun getLogsOfService(serviceId: Int): List<Int> =
        serviceMap[serviceId].map { it.id }

    fun search(serviceId: Int, searchString: String): List<String> =
        serviceMap[serviceId].map { it.message }.filter { it.contains(searchString) }

    companion object {
        private class LogEntry(val id: Int, val message: String)
    }
}
